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

    public void insert(UsersEntity u){
        Session session =getDAOManager();
        try {
            session.beginTransaction();
            session.persist(u);
            session.getTransaction().commit();
        } catch (HibernateException e){
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.flush();
            session.close();
        }
    }
}
