package com.imagine.world.phppp;

import com.imagine.world.CommonValidation;
import com.imagine.world.dao.PhpbbUsersDAO;
import com.imagine.world.models.PhpbbUsersEntity;

/**
 * Created by tuanle on 7/31/14.
 */
public class PhpbbValidation extends CommonValidation {
    private static PhpbbUsersDAO phpbbUsersDAO = new PhpbbUsersDAO();

    public static  boolean isExistedUsername(String username){
        PhpbbUsersEntity user = phpbbUsersDAO.getUserByUsername(username);
        return !(user == null);
    }

    public static boolean isExistedEmailAddress(String emailAddress){
        PhpbbUsersEntity user = phpbbUsersDAO.getUserByEmail(emailAddress);
        return !(user == null);
    }
}
