package com.imagine.world;

import com.imagine.world.config.PropertiesValue;
import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by letuan on 4/21/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "com/imagine/world/myspring-servlet.xml")
public class TestPropertiesUtil extends TestCase{

    public void testLoading(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/imagine/world/myspring-servlet.xml");// TOTO : it use file name only
        PropertiesValue v = (PropertiesValue) context.getBean("propertiesValue");//equivalent to @Autowire
//        System.out.println(v.VBB_REQUEST_CREATE_CONTEXT);
    }
}
