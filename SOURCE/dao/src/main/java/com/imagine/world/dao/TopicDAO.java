package com.imagine.world.dao;

import com.imagine.world.customdaosupport.CustomDAOSupport;
import com.imagine.world.models.TopicsEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tuanlhd on 10/24/14.
 */
public class TopicDAO extends CustomDAOSupport implements Serializable {

    public List<TopicsEntity> getTopicById(int topicId){

        Query query = getSession().createQuery(" select t from TopicsEntity t where t.topicId = :topicId ");

        query.setParameter("topicId", topicId);

        List<TopicsEntity> results = query.list();
        return results;
    }

    public void persist(TopicsEntity topicsEntity){
        try {
            getSession().beginTransaction();
            getSession().persist(topicsEntity);
            getSession().getTransaction().commit();
        } catch (HibernateException e){
            getSession().getTransaction().rollback();
            throw e;
        } finally {
            getSession().flush();
        }
    }

    public void merge(TopicsEntity topicsEntity){
        try {
            getSession().beginTransaction();
            getSession().merge(topicsEntity);
            getSession().getTransaction().commit();
        } catch (HibernateException e){
            getSession().getTransaction().rollback();
        } finally {
            getSession().flush();
        }
    }
}
