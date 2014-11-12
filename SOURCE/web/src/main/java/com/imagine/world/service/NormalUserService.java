package com.imagine.world.service;

import com.google.common.base.Preconditions;
import com.imagine.world.common.PostApproveType;
import com.imagine.world.common.TopicApproveType;
import com.imagine.world.dao.TopicDAO;
import com.imagine.world.exception.AuthorizationException;
import com.imagine.world.exception.MyException;
import com.imagine.world.models.PostsEntity;
import com.imagine.world.models.TopicsEntity;
import com.imagine.world.models.UserProfile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by tuan on 10/9/14.
 *
 */
@Component
public class NormalUserService extends BaseService {

    @Override
    public void logOut() throws AuthorizationException {
        super.logOut();
    }

    @Override
    public void issueArticle(HttpServletResponse r) throws AuthorizationException {
        throw new AuthorizationException("Current user is not allow to use this function");
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
        super.modifyUser(response, userId, username, currentEmail, newEmail, newPass, currentPass, userBirthday, userType, userAvatar, userAvatarType, userAvatarWidth, userAvatarHeight, userSig, userFrom);
    }

    @Override
    public Map getTopics(HttpServletResponse response, int forumId, int page, int num, String sortType, byte topicApproved) throws MyException {

        /**
         * check permission if approved is not 0
         */
        if( topicApproved != TopicApproveType.PASS_WAITING.getValue())
            throw new AuthorizationException("This is normal user, you can not use topicApproved is different 0");

        return super.getTopics(
                response,
                forumId,
                page,
                num,
                sortType,
                topicApproved
        );
    }


    @Override
    public Map getPosts(HttpServletResponse response, int forumId, int topicId, int page, int num, String sortType,byte postApproveType) throws MyException {
        if( postApproveType != PostApproveType.PASS_WAITING.getValue())
            throw new AuthorizationException("This is normal user, you can not use topicApproved is different 0");

        return super.getPosts(response, forumId,  topicId, page,  num, sortType, postApproveType);
    }

    @Override
    public void postInfo() {
        super.postInfo();
    }

    @Override
    public void authorize(HttpServletResponse httpServletResponse, String email, String password) throws MyException {
        super.authorize(httpServletResponse, email, password);
    }

    @Override
    public void register(String username, String email, String password, Date birthday, Integer userType, BigDecimal timezone, Integer rank, String avatar, String avatarType, Short avatarWidth, Short avatarHeight, String userSig, String userFrom) throws MyException {
        super.register(username, email, password, birthday, userType, timezone, rank, avatar, avatarType, avatarWidth, avatarHeight, userSig, userFrom);
    }

    @Override
    public void uploadTempAvatar(MultipartFile multipartFile) throws MyException {
        super.uploadTempAvatar(multipartFile);
    }

    @Override
    public UserProfile userInfo(HttpServletResponse response) throws MyException {
        return super.userInfo(response);
    }

    @Override
    public void checkLogin(HttpServletResponse response) throws MyException {
        super.checkLogin(response);
    }

    @Override
    public void deletePost(int idPost) throws AuthorizationException {
        super.deletePost(idPost);
    }

    @Override
    public void deleteTopic(int topicId) throws AuthorizationException {
        /**
         * Check Topic is belonged current user
         * If it's no must throw exception
         */
        TopicDAO topicDAO = new TopicDAO();
        List<TopicsEntity> topicsEntityList = topicDAO.getTopicById(topicId);
        Preconditions.checkArgument(!topicsEntityList.isEmpty(), "There are no topic to delete by topicId=" + topicId);
        Preconditions.checkArgument(!topicsEntityList.get(0)
                .getTopicFirstPosterName()
                .equalsIgnoreCase(session.getUsername()),
                "This topic is not belong to user "+session.getUsername()
        );
        super.deleteTopic(topicId);
    }

    @Override
    public void modifyPost() throws AuthorizationException {
        super.modifyPost();
    }

    @Override
    public void modifyTopic() throws AuthorizationException {
        super.modifyTopic();
    }

    @Override
    public void postNew(HttpServletResponse response, int forumId, String subject, String text) throws MyException {
        super.postNew(response, forumId, subject, text);
    }

    @Override
    public TopicsEntity addNewTopic(int forumId, String title, int posterId, long topicTime, int views, byte status, byte type, int firstPostId, String firstPosterName, int lastPostId, String lastPosterName, int lastPosterId, int approveType) {
        return super.addNewTopic(forumId, title, posterId, topicTime, views, status, type, firstPostId, firstPosterName, lastPostId, lastPosterName, lastPosterId, approveType);
    }

    @Override
    public PostsEntity addNewPost(int topicId, int forumId, int posterId, long postTime, String postUsername, String subject, String text, String checksum, long editTime, String editReason, int editUser, String posterIp) {
        return super.addNewPost(topicId, forumId, posterId, postTime, postUsername, subject, text, checksum, editTime, editReason, editUser, posterIp);
    }

    @Override
    public void reply(HttpServletResponse response, int forumId, int topicId, String subject, String text) throws MyException {
        super.reply(response, forumId, topicId, subject, text);
    }
}
