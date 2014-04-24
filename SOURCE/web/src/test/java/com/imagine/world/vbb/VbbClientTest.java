package com.imagine.world.vbb;

import com.imagine.world.config.PropertiesValue;
import junit.framework.TestCase;
import org.apache.http.HttpException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by letuan on 4/19/14.
 */
public class VbbClientTest extends TestCase{

    public void testLogin() throws URISyntaxException, IOException, HttpException {
        ApplicationContext context = new ClassPathXmlApplicationContext( "myspring-servlet.xml" );// TOTO : it use file name only
        PropertiesValue v = (PropertiesValue) context.getBean("propertiesValue");//equivalent to @Autowire
        VbbClient vbb = new VbbClient();
        vbb.login(v.VBB_REQUEST_PATH_AUTH_LOGIN,v.VBB_V_URL,v.VBB_USERNAME_ADMIN,v.VBB_PASSWORD_MD5_ADMIN);
//        vbb.createNewThread();

    }
}
