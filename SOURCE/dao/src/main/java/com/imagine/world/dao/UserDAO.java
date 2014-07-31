package com.imagine.world.dao;

import com.imagine.world.customdaosupport.CustomDAOSupport;
import com.imagine.world.models.MyproductEntity;
import com.imagine.world.models.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tuanle on 7/7/14.
 */
public class UserDAO extends CustomDAOSupport implements Serializable {

    public static final String BIRTHDAY_DATE_FORMAT = "dd-MM-yyyy";

    public UserEntity getUserByUsername(String username){

        Query query = getDAOManager().createQuery(" select t from UserEntity t where t.username = :username ");

        query.setParameter("username", username);


        List<UserEntity> results = query.list();

        if (results !=null && results.size() > 0) {
            return results.get(0);
        }

        return null;
    }

    public UserEntity getUserByEmail(String email){

        Query query = getDAOManager().createQuery(" select t from UserEntity t where t.email = :email ");

        query.setParameter("email", email);


        List<UserEntity> results = query.list();

        if (results !=null && results.size() > 0) {
            return results.get(0);
        }

        return null;
    }

    public void update(UserEntity arg0){
        try {
            getDAOManager().beginTransaction();
            getDAOManager().merge(arg0);
            getDAOManager().getTransaction().commit();
        } catch (HibernateException e){
            getDAOManager().getTransaction().rollback();
        }


    }
}
