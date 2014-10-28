package com.imagine.world.service;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.io.Files;
import com.imagine.world.common.AvatarType;
import com.imagine.world.common.DefaultUtils;
import com.imagine.world.common.TopicStatus;
import com.imagine.world.common.TopicType;
import com.imagine.world.dao.ForumDAO;
import com.imagine.world.dao.PostDAO;
import com.imagine.world.dao.TopicDAO;
import com.imagine.world.dao.UserDAO;
import com.imagine.world.exception.AuthorizationException;
import com.imagine.world.exception.InprocessException;
import com.imagine.world.exception.MyException;
import com.imagine.world.models.PostsEntity;
import com.imagine.world.models.TopicsEntity;
import com.imagine.world.models.UserProfile;
import com.imagine.world.models.UsersEntity;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;


/**
 * Created by tuan on 10/9/14.
 *
 */
@Component
public class NormalUserService extends NoLoggedInUserService {

    @Override
    public void logOut(ServiceState serviceState) {
        session.clearData();
        serviceState.changeToNoLoggedInUser();
    }

    @Override
    public void issueArticle() throws AuthorizationException {
        throw new AuthorizationException("Current user is not allow to use this function");
    }

    @Override
    public UserProfile userInfo(HttpServletRequest httpServletRequest) throws MyException {
        /**
         * Check login
         */
//        checkLogin(httpServletRequest);
        //Does not need check login enymore. cause the State pattern have done it for me.

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
//            HttpServletRequest httpServletRequest,
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
        }

        if(!Strings.isNullOrEmpty(newEmail)){
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
//            HttpServletRequest httpServletRequest,
            int forumId,String subject,String text) throws MyException {
//        this.checkLogin(httpServletRequest);
        this.checkPermission();

        /**
         * Do Business
         */
        ForumDAO forumDAO = new ForumDAO();
        Preconditions.checkState(forumDAO.getForumById(forumId).size() > 0, "There are no existed this forum");

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
                session.getUserId()//lastPostId
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
        topicDAO.persist(topicsEntity);

    }

    @Override
    public void getTopics() throws AuthorizationException {
        throw new AuthorizationException("This user does not login");
    }

    @Override
    public void postInfo() {

    }

    @Override
    public void getPosts() {

    }

    @Override
    public TopicsEntity addNewTopic(int forumId, String title, int posterId, long topicTime,
                            int views, byte status, byte type,
                            int firstPostId, String firstPosterName,
                            int lastPostId, String lastPosterName, int lastPosterId) {
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
        return postsEntity;
    }

    @Override
    public void reply(HttpServletRequest httpServletRequest,int forumId, int topicId, String subject, String text) throws MyException {
        this.checkPermission();

        /**
         * Do Business
         */
        TopicDAO topicDAO = new TopicDAO();
        List<TopicsEntity> topicsEntityList = topicDAO.getTopicById(topicId);
        if(topicsEntityList.size()>0){

        } else {
            throw new InprocessException("THERE ARE NOT EXIST topicId " + topicId);
        }
    }
}
