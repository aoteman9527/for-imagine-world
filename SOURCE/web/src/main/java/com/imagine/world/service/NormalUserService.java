package com.imagine.world.service;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.imagine.world.common.*;
import com.imagine.world.dao.ForumDAO;
import com.imagine.world.dao.PostDAO;
import com.imagine.world.dao.TopicDAO;
import com.imagine.world.dao.UserDAO;
import com.imagine.world.exception.AuthorizationException;
import com.imagine.world.exception.InprocessException;
import com.imagine.world.exception.MyException;
import com.imagine.world.models.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * Created by tuan on 10/9/14.
 *
 */
@Component
public class NormalUserService extends NoLoggedInUserService {

    @Override
    public void logOut() {
        session.clearData();
        serviceState.changeToNoLoggedInUser();
    }

    @Override
    public void issueArticle(HttpServletResponse r) throws AuthorizationException {
        throw new AuthorizationException("Current user is not allow to use this function");
    }

    @Override
    public UserProfile userInfo(HttpServletResponse httpServletResponse) throws MyException {
        /**
         * Check login
         */
        //Does not need check login , because this state mean user logged in.

        /**
         * Do business
         */
        String email = session.getEmail();
        UserDAO userDAO = new UserDAO();
        List<UsersEntity> usersEntityList = userDAO.getUserByEmail(email);
        if(usersEntityList.isEmpty()){
            throw new InprocessException("Finding user does not exist "+email );
        }
        return new UserProfile(usersEntityList.get(0));

    }

    /**
     *
     * @param userId REQUIRED
     * @param username
     * @param currentEmail
     * @param newEmail
     * @param newPass
     * @param currentPass
     * @param userBirthday
     * @param userType
     * @param userAvatar
     * @param userAvatarType
     * @param userAvatarWidth
     * @param userAvatarHeight
     * @param userSig
     * @param userFrom
     * @throws MyException
     */
    @Override
    public void modifyUser(
            HttpServletResponse response,
            int userId, String username, String currentEmail, String newEmail,
                           String newPass, String currentPass, String userBirthday,
                           int userType, String userAvatar, String userAvatarType,
                           Short userAvatarWidth, Short userAvatarHeight, String userSig, String userFrom) throws MyException {
        /**
         * Check login
         */
//        this.checkLogin(httpServletRequest);

        /**
         * Do business
         */
        UserDAO userDAO = new UserDAO();
        UsersEntity usersEntity = userDAO.getUserById(userId).get(0);
        if(!Strings.isNullOrEmpty(username)){
            Preconditions.checkArgument(USERNAME_PATTERN_C.matcher(username).matches(),"Invalid username "+username);
            usersEntity.setUsername(username);
            usersEntity.setUsernameClean(username.toLowerCase());
        }

        if(!Strings.isNullOrEmpty(newEmail)){
            Preconditions.checkArgument(EMAIL_PATTERN_C.matcher(newEmail).matches(),"Invalid format email "+ newEmail);
            Preconditions.checkArgument(currentEmail.equalsIgnoreCase(usersEntity.getUserEmail()),"Current email does not match");
            usersEntity.setUserEmail(newEmail);
        }

        if(!Strings.isNullOrEmpty(newPass)){
            Preconditions.checkArgument(currentPass.equals(usersEntity.getUserPassword()),"Current password does not match");
            usersEntity.setUserPassword(newPass);
        }

        if(!Strings.isNullOrEmpty(userBirthday)){
            try {
                birthdayFormat.parse(userBirthday);
            } catch (ParseException e) {
                e.printStackTrace();
                throw new InprocessException(e.getMessage());
            }
            usersEntity.setUserBirthday(userBirthday);
        }

        if(!Strings.isNullOrEmpty(userAvatar)&&!Strings.isNullOrEmpty(userAvatarType)){
            if(userAvatarType == AvatarType.UPLOADED.getValue()){
                String tempPath = session.getTempAvatarPath();
                File tempFile = new File(tempPath);
                String newPath = PATH_AVATAR_FINAL+tempFile.getName();
                userAvatar = newPath;
                try {
                    Files.move(tempFile,new File(newPath));
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new InprocessException("ERROR moving temp avatar to fixed local "+e.getMessage());
                }
            }

            usersEntity.setUserAvatar(userAvatar);
            usersEntity.setUserAvatarType(new Integer(AvatarType.valueOf(userAvatarType.toUpperCase()).getValue2()).byteValue());
            usersEntity.setUserAvatarWidth(userAvatarWidth);
            usersEntity.setUserAvatarHeight(userAvatarHeight);
        }

        if(!Strings.isNullOrEmpty(userSig)){
            usersEntity.setUserSig(userSig);
        }

        if(!Strings.isNullOrEmpty(userFrom)){
            usersEntity.setUserFrom(userFrom);
        }

        userDAO.persist(usersEntity);

        this.authorize(
                response,
                usersEntity.getUserEmail(),
                usersEntity.getUserPassword()
        );
    }

    @Override
    public void deletePost() {

    }

    @Override
    public void deleteTopic() {

    }

    @Override
    public void modifyPost() {

    }

    @Override
    public void modifyTopic() {

    }

    @Override
    public void postNew(
            HttpServletResponse response,
            int forumId,String subject,String text) throws MyException {

        /**
         * does not need check logged in. because this state . user were logged in.
         */
        this.checkPermission();

        /**
         * Do Business
         */
        ForumDAO forumDAO = new ForumDAO();
        Preconditions.checkState(forumDAO.getForumById(forumId).isEmpty()==false, "There are no existed this forum");

        TopicsEntity topicsEntity = this.addNewTopic(forumId,subject,
                session.getUserId(),//userId
                System.currentTimeMillis(), //topicTime
                0,//views
                TopicStatus.ITEM_UNLOCKED.getValue(), //default
                TopicType.POST_NORMAL.getValue(), //default
                0,//Cause it is unknown the new post
                session.getUsername(),//firstPostName
                0,//this equal with first post
                session.getUsername(),//lastPostName
                session.getUserId(),//lastPostId
                TopicApproveType.ALLOWABLE.getValue()//DEFAULT allow
                );

        PostsEntity postsEntity = this.addNewPost(topicsEntity.getTopicId(),
                forumId,
                session.getUserId(),//PosterId
                System.currentTimeMillis(),//postTime
                session.getUsername(),//PosterUsername
                subject,
                text,//PostText
                new String(DigestUtils.md5(text)),
                -1, //editTime
                "",//Default
                0,//editUser
                request.getRemoteAddr()
        );

        /**
         * update Topic first_post_id
         * update Topic last_post_id
         */
        topicsEntity.setTopicFirstPostId(postsEntity.getPostId());
        topicsEntity.setTopicLastPosterId(postsEntity.getPostId());
        TopicDAO topicDAO = new TopicDAO();
        topicDAO.merge(topicsEntity);

    }

    @Override
    public Map getTopics(HttpServletResponse response, int forumId, int page, int num, String sortType, byte topicApproved) throws AuthorizationException {
        /**
         * Does not need to check login. cause thi state mean logged in.
         */
        this.checkPermission();
        //TODO : if approved is existed and view post that does not approve need a check user permission
        //TODO handle topicApproved
        /**
         * Do business
         */
        String sortCondition=TopicSortType.valueOf(sortType.toUpperCase()).getValue();//TODO
        TopicDAO topicDAO = new TopicDAO();
        List<TopicsEntity> topicsEntities = topicDAO.getTopicBy(
                forumId,
                sortCondition,
                TopicApproveType.ALLOWABLE.getValue(),
                page,
                num
        );

        List<Topic> topics = Lists.newArrayList();
        Iterator<TopicsEntity> it = topicsEntities.iterator();
        TopicsEntity t;
        while(it.hasNext()){
            t = it.next();
            topics.add(new Topic(t));
        }

        return ImmutableMap.<String, Object>builder().
                put("name", "Topics of forumId " + forumId).
                put("size", topics.size()).
                put("topics",topics).
                build();
    }


    @Override
    public Map getPosts(HttpServletResponse response, int forumId, int topicId, int page, int num, String sortType) {

        return null;
    }

    @Override
    public void postInfo() {

    }

    @Override
    public TopicsEntity addNewTopic(int forumId, String title, int posterId, long topicTime,
                            int views, byte status, byte type,
                            int firstPostId, String firstPosterName,
                            int lastPostId, String lastPosterName, int lastPosterId, int approveType) {
        TopicsEntity topicsEntity = new TopicsEntity();
        topicsEntity.setForumId(forumId);
        topicsEntity.setTopicTitle(title);
        topicsEntity.setTopicPoster(posterId);
        topicsEntity.setTopicTime((int) (topicTime / 1000));
        topicsEntity.setTopicViews(views);
        topicsEntity.setTopicStatus(status);
        topicsEntity.setTopicType(type);
        topicsEntity.setTopicFirstPostId(firstPostId);
        topicsEntity.setTopicFirstPosterName(firstPosterName);
        topicsEntity.setTopicLastPostId(lastPostId);
        topicsEntity.setTopicLastPosterName(lastPosterName);
        topicsEntity.setTopicLastPosterId(lastPosterId);

        DefaultUtils.setDefaultValueTopic(topicsEntity);

        TopicDAO topicDAO = new TopicDAO();
        topicDAO.persist(topicsEntity);
        topicsEntity.setTopicId(topicDAO.getLastInsertId());
        return topicsEntity;
    }

    @Override
    public PostsEntity addNewPost(int topicId, int forumId, int posterId,
                           long postTime, String postUsername,
                           String subject, String text, String checksum,
                           long editTime, String editReason, int editUser, String posterIp) {
        PostsEntity postsEntity = new PostsEntity();
        postsEntity.setTopicId(topicId);
        postsEntity.setForumId(forumId);
        postsEntity.setPosterId(posterId);
        postsEntity.setPostTime((int) (postTime / 1000));
        postsEntity.setPostUsername(postUsername);
        postsEntity.setPostSubject(subject);
        postsEntity.setPostText(text);
        postsEntity.setPostChecksum(checksum);
        postsEntity.setPostEditTime((int) (editTime / 1000));
        postsEntity.setPostEditReason(editReason);
        postsEntity.setPostEditUser(editUser);
        postsEntity.setPosterIp(posterIp);

        DefaultUtils.setDefaultValuePost(postsEntity);

        PostDAO postDAO = new PostDAO();
        postDAO.persist(postsEntity);

        postsEntity.setPostId(postDAO.getLastInsertId());

        return postsEntity;
    }

    @Override
    public void reply(HttpServletResponse response,int forumId, int topicId, String subject, String text) throws MyException {
        this.checkPermission();

        /**
         * does not need check logged in. because this state . user were logged in.
         */
        this.checkPermission();

        /**
         * Do Business
         */
        //check forum existed
        ForumDAO forumDAO = new ForumDAO();
        Preconditions.checkState(forumDAO.getForumById(forumId).isEmpty()==false, "There are no existed this forum "+forumId);

        //check topic existed
        TopicDAO topicDAO = new TopicDAO();
        List<TopicsEntity> topicsEntityList = topicDAO.getTopicById(topicId);
        Preconditions.checkState(topicsEntityList.isEmpty()==false, "There are no existed this topic "+topicId);

        PostsEntity postsEntity = this.addNewPost(
                topicId,
                forumId,
                session.getUserId(),
                System.currentTimeMillis(),
                session.getUsername(),
                subject,
                text,
                new String(DigestUtils.md5(text)),//checksum
                -1,//editTime
                "",//editReason
                0,//editUser
                request.getRemoteAddr()
        );
        topicsEntityList.get(0).setTopicLastPosterId(session.getUserId());
        topicsEntityList.get(0).setTopicLastPostTime((int) (System.currentTimeMillis() / 1000));
        topicsEntityList.get(0).setTopicLastPostId(postsEntity.getPostId());
        topicDAO.merge(topicsEntityList.get(0));
    }
}
