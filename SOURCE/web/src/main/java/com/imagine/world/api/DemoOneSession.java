package com.imagine.world.api;

import com.imagine.world.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created by tuanlhd on 12/4/14.
 */
@Service
@RequestMapping
public class DemoOneSession extends BaseApi {

    @Autowired
    HttpServletRequest request;

    @RequestMapping(value = "login1",method = RequestMethod.GET)
    @ResponseBody
    public void login1(
            HttpServletResponse response
    ) throws MyException {
        request.getSession().setAttribute("login1",true);
    }

    @RequestMapping(value = "login2",method = RequestMethod.GET)
    @ResponseBody
    public void login2(
            HttpServletResponse response
    ) throws MyException {
        request.getSession().setAttribute("login2",true);
    }

    @RequestMapping(value = "info1",method = RequestMethod.GET)
    @ResponseBody
    public Object info1(
            HttpServletResponse response
    ) throws MyException {
        return request.getSession().getAttribute("login1");
    }

    @RequestMapping(value = "info2",method = RequestMethod.GET)
    @ResponseBody
    public Object info2(
            HttpServletResponse response
    ) throws MyException {
        return request.getSession().getAttribute("login2");
    }

    @RequestMapping(value = "concentrateAuthorize",method = RequestMethod.GET)
    @ResponseBody
    public void concentrateAuthorize(
            HttpServletResponse response
    ) throws MyException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            if(!key.equalsIgnoreCase("host"))
            {
                String value = request.getHeader(key);
                requestHeaders.add(key, value);
            }

        }
        HttpEntity requestEntity = new HttpEntity(null, requestHeaders);
        ResponseEntity<String> rssResponse = restTemplate.exchange(
                "http://localhost:8080/login1",
                HttpMethod.GET,
                requestEntity,
                String.class);
        String rss = rssResponse.getBody();

        String sessionId = null;
        if(!rssResponse.getHeaders().get(HttpHeaders.SET_COOKIE).isEmpty())
            sessionId = rssResponse.getHeaders().get(HttpHeaders.SET_COOKIE).get(0);

        rssResponse = restTemplate.exchange(
                "http://localhost:8282/login2",
                HttpMethod.GET,
                requestEntity,
                String.class);
        rss = rssResponse.getBody();
        if(!rssResponse.getHeaders().get(HttpHeaders.SET_COOKIE).isEmpty())
            sessionId +=";"+rssResponse.getHeaders().get(HttpHeaders.SET_COOKIE).get(0);

        response.addHeader(HttpHeaders.SET_COOKIE, sessionId);

    }

    @RequestMapping(value = "shareSessionTest/save",method = RequestMethod.GET)
    @ResponseBody
    public void shareSessionTestSave(
            HttpServletResponse response
    ) throws MyException {
        request.getSession().setAttribute("shareSessionTest","THIS IS A TEXT");
    }

    @RequestMapping(value = "shareSessionTest/load",method = RequestMethod.GET)
    @ResponseBody
    public String shareSessionTestLoad(
            HttpServletResponse response
    ) throws MyException {
        return request.getSession().getAttribute("shareSessionTest").toString();
    }

}
