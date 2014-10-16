package com.imagine.world.dao;

import com.imagine.world.customdaosupport.CustomDAOSupport;
import com.imagine.world.models.UsersEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tuanle on 7/7/14.
 */
public class UserDAO extends CustomDAOSupport implements Serializable {

    public static final String BIRTHDAY_DATE_FORMAT = "dd-MM-yyyy";


    public UsersEntity getUserByUsername(String username){

        Query query = getSession().createQuery(" select t from UsersEntity t where t.username = :username ");

        query.setParameter("username", username);


        List<UsersEntity> results = query.list();

        if (results !=null && results.size() > 0) {
            return results.get(0);
        }

        return null;
    }

    public UsersEntity getUserByEmail(String email){

        Query query = getSession().createQuery(" select t from UsersEntity t where t.userEmail = :email ");

        query.setParameter("email", email);


        List<UsersEntity> results = query.list();

        if (results !=null && results.size() > 0) {
            return results.get(0);
        }

        return null;
    }

    public void merge(UsersEntity arg0){
        try {
            getSession().beginTransaction();
            getSession().merge(arg0);
            getSession().getTransaction().commit();
        } catch (HibernateException e){
            getSession().getTransaction().rollback();
        } finally {
            getSession().flush();
        }
    }

    public void insert(UsersEntity u){
        try {
            getSession().beginTransaction();
            getSession().persist(u);
            getSession().getTransaction().commit();
        } catch (HibernateException e){
            getSession().getTransaction().rollback();
            throw e;
        } finally {
            getSession().flush();
        }
    }
}
