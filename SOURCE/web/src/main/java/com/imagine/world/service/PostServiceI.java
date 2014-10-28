package com.imagine.world.service;

import com.imagine.world.exception.AuthorizationException;
import com.imagine.world.exception.MyException;
import com.imagine.world.models.PostsEntity;
import com.imagine.world.models.TopicsEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public void getTopics() throws AuthorizationException;
    public void postInfo();
    public void getPosts();

    public void checkPermission();
    public TopicsEntity addNewTopic(int forumId, String title,
                            int posterId, long topicTime,
                            int views, byte status, byte type, int firstPostId, String firstPosterName,
                            int lastPostId, String lastPosterName, int lastPosterId);
    public PostsEntity addNewPost(int topicId, int forumId, int posterId,
                           long postTime, String postUsernae,
                           String subject, String text, String checksum,
                           long editTime, String editReason, int editUser, String posterIp);
}
