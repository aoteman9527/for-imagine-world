package com.imagine.world.service;

import com.imagine.world.common.PostApproveType;
import com.imagine.world.common.PostSortType;
import com.imagine.world.common.TopicApproveType;
import com.imagine.world.common.TopicSortType;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by tuanlhd on 10/27/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:test-myspring-servlet.xml")
@WebAppConfiguration
public class PostServiceTest extends MyAbstractTest {

    @Autowired
    ServiceState serviceState ;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    @Ignore
    public void testRegisterNewUserForPost() throws Exception {

        String username = "tuanle23";
        String email= "letuan@gmail23.com";
        String password= "123456";
        String birthday= "2011-11-12";
        this.mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", username)
                .param("email", email)
                .param("password", password)
                .param("birthday", birthday)
        ).andDo(new ResultHandler() {
            @Override
            public void handle(MvcResult mvcResult) throws Exception {
                System.out.println(mvcResult.getResponse().getContentAsString());;
            }
        }).andExpect(status().isOk());
    }

    @Test
    public void testPostNew() throws Exception {

        this.mockMvc.perform(post("/authorize")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("email", "letuan@gmail.com")
                .param("password", "123456")
        ).andDo(new ResultHandler() {
            @Override
            public void handle(MvcResult mvcResult) throws Exception {
                System.out.println(mvcResult.getResponse().getContentAsString());;
            }
        }).andExpect(status().isOk());

        this.mockMvc.perform(post("/postNew")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("forumId", "1")
                .param("subject", "THIS IS SUBJECT "+UserServiceI.simpleDateFormat.format(new Date(System.currentTimeMillis())))
                .param("text", "HUHUHUHUHUHUHUHUHU ")
        ).andDo(new ResultHandler() {
            @Override
            public void handle(MvcResult mvcResult) throws Exception {
                System.out.println(mvcResult.getResponse().getContentAsString());;
            }
        }).andExpect(status().isOk());
    }

    @Test
    public void testReply() throws Exception {

        this.mockMvc.perform(post("/authorize")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("email", "letuan@gmail.com")
                .param("password", "123456")
        ).andDo(new ResultHandler() {
            @Override
            public void handle(MvcResult mvcResult) throws Exception {
                System.out.println(mvcResult.getResponse().getContentAsString());;
            }
        }).andExpect(status().isOk());

        this.mockMvc.perform(post("/reply")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("forumId", "1")
                .param("topicId", "34")
                .param("subject", "THIS IS REPL Y SUBJECT "+UserServiceI.simpleDateFormat.format(new Date(System.currentTimeMillis())))
                .param("text", "THIS IS REPLAY POST")
        ).andDo(new ResultHandler() {
            @Override
            public void handle(MvcResult mvcResult) throws Exception {
                System.out.println(mvcResult.getResponse().getContentAsString());;
            }
        }).andExpect(status().isOk());

        this.mockMvc.perform(post("/reply")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("forumId", "22222222")//WRONG FORUM
                .param("topicId", "34")
                .param("subject", "THIS IS REPL Y SUBJECT "+UserServiceI.simpleDateFormat.format(new Date(System.currentTimeMillis())))
                .param("text", "THIS IS REPLAY POST")
        ).andDo(new ResultHandler() {
            @Override
            public void handle(MvcResult mvcResult) throws Exception {
                System.out.println(mvcResult.getResponse().getContentAsString());
                ;
            }
        }).andExpect(status().is5xxServerError());
        this.mockMvc.perform(post("/reply")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("forumId", "1")
                .param("topicId", "3444444")//WRONG TOPIC
                .param("subject", "THIS IS REPL Y SUBJECT " + UserServiceI.simpleDateFormat.format(new Date(System.currentTimeMillis())))
                .param("text", "THIS IS REPLAY POST")
        ).andDo(new ResultHandler() {
            @Override
            public void handle(MvcResult mvcResult) throws Exception {
                System.out.println(mvcResult.getResponse().getContentAsString());;
            }
        }).andExpect(status().is5xxServerError());
    }

    @Test
    public void testViewForum() throws Exception {
        this.mockMvc.perform(post("/authorize")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("email", "letuan@gmail.com")
                .param("password", "123456")
        ).andDo(new ResultHandler() {
            @Override
            public void handle(MvcResult mvcResult) throws Exception {
                System.out.println(mvcResult.getResponse().getContentAsString());;
            }
        }).andExpect(status().isOk());


        int forumId = 1;
        int page = 0;
        int num = 100;
        String sortType = TopicSortType.LAST_POST_TIME_ASC.name();
        this.mockMvc.perform(post("/getTopics")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("forumId", forumId + "")
                .param("page", page+"")
                .param("num", num+"")
                .param("sortType", sortType)
                .param("topicApproved", TopicApproveType.PASS_WAITING.getValue()+"")
        ).andDo(new ResultHandler() {
            @Override
            public void handle(MvcResult mvcResult) throws Exception {
                System.out.println(mvcResult.getResponse().getContentAsString());;
            }
        }).andExpect(status().isOk());
    }

    @Test
    public void testViewForumFail() throws Exception {
        this.mockMvc.perform(post("/authorize")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("email", "letuan@gmail.com")
                .param("password", "123456")
        ).andDo(new ResultHandler() {
            @Override
            public void handle(MvcResult mvcResult) throws Exception {
                System.out.println(mvcResult.getResponse().getContentAsString());;
            }
        }).andExpect(status().isOk());


        int forumId = 1;
        int page = 0;
        int num = 100;
        String sortType = TopicSortType.LAST_POST_TIME_ASC.name();
        this.mockMvc.perform(post("/getTopics")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("forumId", forumId+"")
                .param("page", page+"")
                .param("num", num+"")
                .param("sortType", sortType)
                .param("topicApproved", TopicApproveType.WAITING.getValue()+"")
        ).andDo(new ResultHandler() {
            @Override
            public void handle(MvcResult mvcResult) throws Exception {
                System.out.println(mvcResult.getResponse().getContentAsString());;
            }
        }).andExpect(status().is4xxClientError());
    }

    @Test
    public void testViewTopic() throws Exception {
        int forumId = 1;
        int topicId = 29;
        int page = 0;
        int num = 100;
        String sortType = PostSortType.POST_TIME_ASC.name();
        this.mockMvc.perform(post("/getPosts")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("forumId", forumId + "")
                .param("topicId", topicId+"")
                .param("page", page+"")
                .param("num", num+"")
                .param("sortType", sortType)
                .param("postApproved", PostApproveType.PASS_WAITING.getValue()+"")
        ).andDo(new ResultHandler() {
            @Override
            public void handle(MvcResult mvcResult) throws Exception {
                System.out.println(mvcResult.getResponse().getContentAsString());
            }
        }).andExpect(status().isOk());
    }
}
