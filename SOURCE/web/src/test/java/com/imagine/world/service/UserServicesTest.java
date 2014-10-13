package com.imagine.world.service;

import com.imagine.world.common.AvatarType;
import com.imagine.world.exception.MyException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * Created by tuan on 10/11/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:test-myspring-servlet.xml")
@Service
public class UserServicesTest extends MyAbstractTest {

    @Autowired
    ServiceState serviceState ;

    @Test
    public void testRegisterUser() throws MyException {

        Random r =new Random();
        serviceState.getService().register("DELETE-"+r.nextInt(10000),r.nextInt()+"@gmail.com",
                r.nextInt(100000)+"",new Date(), null,null,null,null,null,null,null,null,null);

        serviceState.getService().uploadTempAvatar(new MockMultipartFile("beeeeep","kia co be co mai toc duoi ga".getBytes()));
        serviceState.getService().register("DELETE-"+r.nextInt(10000),r.nextInt()+"@gmail.com",
                r.nextInt(100000)+"",new Date(), 1,new BigDecimal(1.00),1000,"BEEEEP", AvatarType.UPLOADED.getValue(),
                null,null,"askjjdh aksdhk","California");

    }
}
