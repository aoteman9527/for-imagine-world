package com.imagine.world;

import com.imagine.world.phppp.PhpbbValidation;
import org.junit.Test;

/**
 * Created by tuanle on 7/31/14.
 */
public class TestValidation extends MyAbstractTest{

    @Test
    public void testIsExistedUser(){
        System.out.println(PhpbbValidation.isExistedUsername("playernodie222"));
    }
}
