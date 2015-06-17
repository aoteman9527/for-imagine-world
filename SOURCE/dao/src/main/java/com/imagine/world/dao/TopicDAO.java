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

    /**
     *
     * @param forumId
     * @param sortCondition : string like "topic_id ASC, topic_time DESC"
     * @param topicApproved
     * @param page : from 0 ~ n
     * @param limit : from 1 ~ n
     * @return
     */
    public List<TopicsEntity> getTopicBy(int forumId, String sortCondition, byte topicApproved, int page, int limit){

        Query query = getSession().createQuery(
                "select t from TopicsEntity t where t.forumId = :forumId and t.topicApproved = :topicApproved " +
                "ORDER BY "+ sortCondition);

        query.setParameter("forumId", forumId);
        query.setParameter("topicApproved", topicApproved);
        query.setMaxResults(limit);
        query.setFirstResult(page*limit);

        List<TopicsEntity> results = query.list();
        return results;
    }

    public void delete(TopicsEntity t){
        getSession().beginTransaction();
        getSession().delete(t);
        getSession().getTransaction().commit();
        getSession().flush();
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

    public void save(TopicsEntity topicsEntity){
        try {
            getSession().beginTransaction();
            getSession().save(topicsEntity);
            getSession().getTransaction().commit();
        } catch (HibernateException e){
            getSession().getTransaction().rollback();
        } finally {
            getSession().flush();
        }
    }
}
