package com.imagine.world.service;

import com.imagine.world.common.PostApproveType;
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
import java.util.Map;

/**
 * Created by tuanlhd on 10/28/14.
 */
@Component
public class NoLoggedInUserService extends BaseService {

    @Override
    public Map getTopics(HttpServletResponse response, int forumId, int page, int num, String sortType, byte topicApproved) throws MyException {
        this.checkLogin(response);
        /**
         * Why this must use serviceStata but thi.getTopic
         * Because after checkLogin. the serviceState was change to Normal user or Power user. we do not know.
         * then let leave the checking permission on each of them.
         */
        return this.serviceState.getService().getTopics(
                response,
                forumId,
                page,
                num,
                sortType,
                topicApproved
        );
    }

    @Override
    public void reply(HttpServletResponse response,int forumId, int topicId, String subject, String text) throws MyException {
        this.checkLogin(response);
        this.serviceState.getService().reply(
                response,
                forumId, topicId, subject, text);
    }

    @Override
    public void postNew(
            HttpServletResponse response,
            int forumId,String subject,String text ) throws MyException {
        this.checkLogin(response);
        this.serviceState.getService().postNew(
                response,
                forumId, subject, text
        );

    }

    @Override
    public void logOut() throws AuthorizationException {

        throw new AuthorizationException("This user does not need to logout cause he have not logged in.");
    }

    @Override
    public void issueArticle(HttpServletResponse response) throws MyException {
        this.checkLogin(response);
        this.serviceState.getService().issueArticle(response);
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
    public void modifyUser(HttpServletResponse response, int userId, String username, String currentEmail, String newEmail, String newPass, String currentPass, String userBirthday, int userType, String userAvatar, String userAvatarType, Short userAvatarWidth, Short userAvatarHeight, String userSig, String userFrom) throws MyException {
        this.checkLogin(response);
        /**
         * after check login. if user is logged in. this will change state to normal user or others.
         */
        this.serviceState.getService().modifyUser(
                response,
                userId,
                username,
                currentEmail,
                newEmail,
                newPass,
                currentPass,
                userBirthday,
                userType,
                userAvatar,
                userAvatarType,
                userAvatarWidth,
                userAvatarHeight,
                userSig,
                userFrom
        );
    }

    @Override
    public void deletePost(HttpServletResponse response,int idPost) throws MyException {
        this.checkLogin(response);
        this.serviceState.getService().deletePost(response, idPost);
    }

    @Override
    public void deleteTopic(HttpServletResponse response,int topicId) throws MyException {
        this.checkLogin(response);
        this.serviceState.getService().deleteTopic(response, topicId);
    }

    @Override
    public void modifyPost(HttpServletResponse response,int forumId, int topicId, int postId, String subject, String text, String reason, String modifier ) throws MyException {
        this.checkLogin(response);
        this.serviceState.getService().modifyPost(response, forumId, topicId, postId, subject, text, reason, modifier);
    }

    @Override
    public void modifyTopic(HttpServletResponse response, int forumId, int topicId, String tittle) throws MyException {
        this.checkLogin(response);
        this.serviceState.getService().modifyTopic(response, forumId, topicId, tittle);
    }

    @Override
    public void postInfo() {
        super.postInfo();
    }

    @Override
    public Map getPosts(HttpServletResponse response, int forumId, int topicId, int page, int num, String sortType, byte postApproveType) throws MyException {
        if( postApproveType != PostApproveType.PASS_WAITING.getValue())
            throw new AuthorizationException("This is no logged in user, you can not use topicApproved is different 0");

        return super.getPosts(response, forumId, topicId, page, num, sortType, postApproveType);
    }
}
