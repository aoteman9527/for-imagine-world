package com.imagine.world.dao;

import com.imagine.world.customdaosupport.CustomDAOSupport;
import com.imagine.world.models.UsersEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tuanle on 7/7/14.
 */
public class UsersDAO extends CustomDAOSupport implements Serializable {

    public static final String BIRTHDAY_DATE_FORMAT = "dd-MM-yyyy";

    public UsersEntity getUserByUsername(String username){

        Query query = getDAOManager().createQuery(" select t from UsersEntity t where t.username = :username ");

        query.setParameter("username", username);


        List<UsersEntity> results = query.list();

        if (results !=null && results.size() > 0) {
            return results.get(0);
        }

        return null;
    }

    public UsersEntity getUserByEmail(String email){

        Query query = getDAOManager().createQuery(" select t from UsersEntity t where t.email = :email ");

        query.setParameter("email", email);


        List<UsersEntity> results = query.list();

        if (results !=null && results.size() > 0) {
            return results.get(0);
        }

        return null;
    }

    public void update(UsersEntity arg0){
        try {
            getDAOManager().beginTransaction();
            getDAOManager().merge(arg0);
            getDAOManager().getTransaction().commit();
        } catch (HibernateException e){
            getDAOManager().getTransaction().rollback();
        }


    }
}
