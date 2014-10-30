package com.imagine.world.service;

import com.imagine.world.exception.AuthorizationException;
import com.imagine.world.exception.MyException;
import com.imagine.world.models.PostsEntity;
import com.imagine.world.models.TopicsEntity;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by tuan on 10/23/14.
 */
public interface PostServiceI {

    public void deletePost() throws AuthorizationException;
    public void deleteTopic() throws AuthorizationException;
    public void modifyPost() throws AuthorizationException;
    public void modifyTopic() throws AuthorizationException;
    public void postNew(
            HttpServletResponse httpServletResponse,
                        int forumId,String subject,String text) throws MyException;
    public void reply(
            HttpServletResponse httpServletResponse,
            int forumId, int topicId, String subject,
                      String text) throws MyException;

    /**
     *
     * @param response
     * @param forumId
     * @param page
     * @param num
     * @param sortType refer to TopicSortType value by enum Name
     * @return
     * @throws MyException
     */
    public Map getTopics(HttpServletResponse response, int forumId, int page, int num, String sortType) throws MyException;
    public void postInfo();
    public void getPosts();

    public void checkPermission();
    public TopicsEntity addNewTopic(int forumId, String title,
                            int posterId, long topicTime,
                            int views, byte status, byte type, int firstPostId, String firstPosterName,
                            int lastPostId, String lastPosterName, int lastPosterId, int approveType);
    public PostsEntity addNewPost(int topicId, int forumId, int posterId,
                           long postTime, String postUsernae,
                           String subject, String text, String checksum,
                           long editTime, String editReason, int editUser, String posterIp);
}
