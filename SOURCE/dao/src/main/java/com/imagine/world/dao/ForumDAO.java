package com.imagine.world.dao;

import com.imagine.world.customdaosupport.CustomDAOSupport;
import com.imagine.world.models.ForumsEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tuanlhd on 10/27/14.
 */
public class ForumDAO extends CustomDAOSupport implements Serializable {
    public List<ForumsEntity> getForumById(int forumId){

        Query query = getSession().createQuery(" select t from ForumsEntity t where t.forumId = :forumId ");

        query.setParameter("forumId", forumId);

        List<ForumsEntity> results = query.list();
        return results;
    }

    public void persist(ForumsEntity forumsEntity){
        try {
            getSession().beginTransaction();
            getSession().persist(forumsEntity);
            getSession().getTransaction().commit();
        } catch (HibernateException e){
            getSession().getTransaction().rollback();
            throw e;
        } finally {
            getSession().flush();
        }
    }

    public void merge(ForumsEntity forumsEntity){
        try {
            getSession().beginTransaction();
            getSession().merge(forumsEntity);
            getSession().getTransaction().commit();
        } catch (HibernateException e){
            getSession().getTransaction().rollback();
        } finally {
            getSession().flush();
        }
    }
}
