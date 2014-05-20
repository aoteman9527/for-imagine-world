package com.imagine.world;

import com.imagine.world.vbb.VbbClient;
import junit.framework.TestCase;
import org.apache.http.HttpException;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by letuan on 4/19/14.
 */
public class VbbClientTest extends TestCase{

    public void testLogin() throws URISyntaxException, IOException, HttpException {
        VbbClient vbb = new VbbClient();

        String requestPathAuthLogin = "http://localhost/forum/upload/auth/login";
        String vUrl = "aHR0cDovL2xvY2FsaG9zdC9mb3J1bS91cGxvYWQv";
        String usernameAdmin = "root";
        String passwordAdmin = "e10adc3949ba59abbe56e057f20f883e";

        vbb.login(requestPathAuthLogin,vUrl,usernameAdmin,passwordAdmin);

        String requestUrl = "http://localhost/forum/upload/create-content/text/";
        String parentId = "4";
        String ret = "http://localhost/forum/upload/forum/main-category/main-forum";
        String title = "new title killing me";
        String text = "killing me softly lajdlksaj aljda lkdjaljdlajdalkd jalkdj a ld kj al kdj la ksjdlkajdl kaj s  d";

        vbb.createNewThread(requestUrl,parentId,ret,title,text);

    }
}
