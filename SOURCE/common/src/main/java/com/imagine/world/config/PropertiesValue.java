package com.imagine.world.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by letuan on 4/22/14.
 */
@Component
@Scope("singleton")
public class PropertiesValue {

    @Value("${vbb.host}")
    public String VBB_HOST;

    @Value("${vbb.request.path.create.content}")
    public String VBB_REQUEST_CREATE_CONTENT;

    @Value("${vbb.request.path.auth.login}")
    public String VBB_REQUEST_PATH_AUTH_LOGIN;

    @Value("${vbb.request.path.auth.logout}")
    public String VBB_REQUEST_PATH_AUTH_LOGOUT;

    @Value("${vbb.username.admin}")
    public String VBB_USERNAME_ADMIN;

    @Value("${vbb.password.md5.admin}")
    public String VBB_PASSWORD_MD5_ADMIN;

    @Value("${vbb.v.url}")
    public String VBB_V_URL;

    @Value("${vbb.request.param.create.content.ret}")
    public String VBB_REQUEST_PARAM_CREATE_CONTENT_RET;

    @Value("${vbb.request.param.create.content.parentid}")
    public String VBB_REQUEST_PARAM_CREATE_CONTENT_PARENTID;

    @Value("${vbb.admincp.login.url}")
    public String VBB_ADMIN_LOGIN_URL;

    @Value("${vbb.admincp.user.update}")
    public String VBB_ADMIN_USER_UPDATE;

    @Value("${vbb.admincp.user.kill}")
    public String VBB_ADMIN_USER_KILL;

    @Value("${phppp.request.path.auth}")
    public String PHPPP_REQUEST_PATH_AUTH;

    @Value("${phppp.request.path.add.user}")
    public String PHPPP_REQUEST_PATH_ADD_USER;

}
