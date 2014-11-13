package com.imagine.world.service;

import com.google.common.base.Preconditions;
import com.imagine.world.common.PostApproveType;
import com.imagine.world.common.TopicApproveType;
import com.imagine.world.dao.PostDAO;
import com.imagine.world.dao.TopicDAO;
import com.imagine.world.exception.AuthorizationException;
import com.imagine.world.exception.MyException;
import com.imagine.world.models.PostsEntity;
import com.imagine.world.models.TopicsEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * Created by tuan on 10/9/14.
 *
 */
@Component
public class NormalUserService extends BaseService {


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
    public void deletePost(HttpServletResponse response, int idPost) throws MyException {
        /**
         * check permission
         * With normal user. he only delete his post
         */
        PostDAO postDAO = new PostDAO();
        List<PostsEntity> postsEntities = postDAO.getPostById(idPost);
        Preconditions.checkArgument(postsEntities.isEmpty());
        Preconditions.checkArgument(postsEntities.get(0).getPosterId()==session.getUserId());

        super.deletePost(response, idPost);
    }

    @Override
    public void deleteTopic(HttpServletResponse response,int topicId) throws MyException {
        /**
         * Check Topic is belonged current user
         * If it's not must throw exception
         */
        TopicDAO topicDAO = new TopicDAO();
        List<TopicsEntity> topicsEntityList = topicDAO.getTopicById(topicId);
        Preconditions.checkArgument(!topicsEntityList.isEmpty(), "There are no topic to delete by topicId=" + topicId);
        Preconditions.checkArgument(!topicsEntityList.get(0)
                .getTopicFirstPosterName()
                .equalsIgnoreCase(session.getUsername()),
                "This topic is not belong to user "+session.getUsername()
        );
        super.deleteTopic(response,topicId);
    }

    @Override
    public void modifyPost(HttpServletResponse response,int forumId, int topicId, int postId, String subject, String text, String reason, String modifier ) throws MyException {
        /**
         * check permission
         * With normal user. he only delete his post
         */
        PostDAO postDAO = new PostDAO();
        List<PostsEntity> postsEntities = postDAO.getPostById(postId);
        Preconditions.checkArgument(postsEntities.isEmpty());
        Preconditions.checkArgument(postsEntities.get(0).getPosterId()==session.getUserId());
        super.modifyPost(response, forumId, topicId, postId, subject, text, reason, modifier);
    }

    @Override
    public void modifyTopic(HttpServletResponse response, int forumId, int topicId, String tittle) throws MyException {
        /**
         * Check Topic is belonged current user
         * If it's not must throw exception
         */
        TopicDAO topicDAO = new TopicDAO();
        List<TopicsEntity> topicsEntityList = topicDAO.getTopicById(topicId);
        Preconditions.checkArgument(!topicsEntityList.isEmpty(), "There are no topic to delete by topicId=" + topicId);
        Preconditions.checkArgument(!topicsEntityList.get(0)
                .getTopicFirstPosterName()
                .equalsIgnoreCase(session.getUsername()),
                "This topic is not belong to user "+session.getUsername()
        );
        super.modifyTopic(response, forumId, topicId, tittle);
    }

    @Override
    public void postNew(HttpServletResponse response, int forumId, String subject, String text) throws MyException {
        //TODO : check the forum allow to post new .
        super.postNew(response, forumId, subject, text);
    }

    @Override
    public void reply(HttpServletResponse response, int forumId, int topicId, String subject, String text) throws MyException {
        //TODO : check topic is closed.
        super.reply(response, forumId, topicId, subject, text);
    }
}
