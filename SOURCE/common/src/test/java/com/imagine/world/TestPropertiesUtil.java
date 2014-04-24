package com.imagine.world;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by letuan on 4/21/14.
 */
public class TestPropertiesUtil extends TestCase{

    public void testLoading(){
        ApplicationContext context = new ClassPathXmlApplicationContext( "myspring-servlet.xml" );// TOTO : it use file name only
        PropertiesValue v = (PropertiesValue) context.getBean("propertiesValue");//equivalent to @Autowire
        System.out.println(v.VBB_REQUEST_CREATE_CONTEXT);
    }
}
