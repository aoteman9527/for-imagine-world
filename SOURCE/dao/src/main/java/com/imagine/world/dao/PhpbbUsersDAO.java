package com.imagine.world.dao;

import com.imagine.world.customdaosupport.CustomDAOSupport;
import com.imagine.world.models.PhpbbUsersEntity;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tuanle on 7/31/14.
 */
public class PhpbbUsersDAO extends CustomDAOSupport implements Serializable {

    public PhpbbUsersEntity getUserByUserId(Object userId){
        Query query = getDAOManager().createQuery(" select t from PhpbbUsersEntity t where t.userId = :userId ");
        query.setParameter("userId", userId);

        List<PhpbbUsersEntity> results = query.list();
        if (results !=null && results.size() > 0) {
            return results.get(0);
        }
        return null;
    }

    public PhpbbUsersEntity getUserByUsername(String username){
        Query query = getDAOManager().createQuery(" select t from PhpbbUsersEntity t where t.username = :username ");
        query.setParameter("username", username);

        List<PhpbbUsersEntity> results = query.list();
        if (results !=null && results.size() > 0) {
            return results.get(0);
        }
        return null;
    }


    public PhpbbUsersEntity getUserByEmail(String emailAddress){
        Query query = getDAOManager().createQuery(" select t from PhpbbUsersEntity t where t.userEmail = :emailAddress ");
        query.setParameter("emailAddress", emailAddress);

        List<PhpbbUsersEntity> results = query.list();
        if (results !=null && results.size() > 0) {
            return results.get(0);
        }
        return null;
    }

}
