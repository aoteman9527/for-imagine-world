package com.imagine.world.common;

import com.imagine.world.dao.UserDAO;

/**
 * Created by tuan on 10/11/14.
 */
public class DaoUtils {
    private static UserDAO userDAO = new UserDAO();
    public static UserDAO getUsersDao(){
        return userDAO;
    }
}
