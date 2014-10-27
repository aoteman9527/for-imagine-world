package com.imagine.world.dao;

import com.imagine.world.customdaosupport.CustomDAOSupport;
import com.imagine.world.models.SessionsEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by tuan on 10/14/14.
 */
public class SessionDAO extends CustomDAOSupport {

    public void merge(SessionsEntity sessionsEntity){
        try {
            getSession().beginTransaction();
            getSession().merge(sessionsEntity);
            getSession().getTransaction().commit();
        } catch (HibernateException e){
            getSession().getTransaction().rollback();
            throw e;
        } finally {
            getSession().flush();
        }
    }

    public void persist(SessionsEntity sessionsEntity){
        try {
            getSession().beginTransaction();
            getSession().persist(sessionsEntity);
            getSession().getTransaction().commit();
        } catch (HibernateException e){
            getSession().getTransaction().rollback();
            throw e;
        } finally {
            getSession().flush();
        }
    }

    public List<SessionsEntity> getSessionByUserId(int userId){

        Query query = getSession().createQuery(" select t from SessionsEntity t where t.sessionUserId = :userId ");

        query.setParameter("userId", userId);

        List<SessionsEntity> results = query.list();

        return results;
    }

    public List<SessionsEntity> getSessionBy(String sessionId, int userId, String ipAddress){
        Query query = getSession().createQuery(" select t from SessionsEntity t where t.sessionId = :sessionId and t.sessionIp = :ipAddress and t.sessionUserId = :userId ");

        query.setParameter("sessionId", sessionId);
        query.setParameter("ipAddress", ipAddress);
        query.setParameter("userId", userId);
        List<SessionsEntity> results = query.list();

        return results;
    }

    public void delete(SessionsEntity sessionsEntity){
        try {
            getSession().beginTransaction();
            getSession().delete(sessionsEntity);
            getSession().getTransaction().commit();
        } catch (HibernateException e){
            getSession().getTransaction().rollback();
            throw e;
        } finally {
            getSession().flush();
        }
    }
}
