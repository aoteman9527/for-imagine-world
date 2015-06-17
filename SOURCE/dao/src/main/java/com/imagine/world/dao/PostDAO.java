package com.imagine.world.dao;

import com.imagine.world.customdaosupport.CustomDAOSupport;
import com.imagine.world.models.PostsEntity;
import com.imagine.world.models.TopicsEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tuanlhd on 10/27/14.
 */
public class PostDAO extends CustomDAOSupport implements Serializable {
    public List<PostsEntity> getPostBy(int forumId, int topicId, int page, int limit, String sortCondition, byte postApproveType){

        Query query = getSession().createQuery(
                "select t from PostsEntity t where t.forumId = :forumId and t.topicId = :topicId and t.postApproved = :postApproveType " +
                        "ORDER BY "+ sortCondition);
        query.setParameter("forumId", forumId);
        query.setParameter("topicId", topicId);
        query.setParameter("postApproveType", postApproveType);
        query.setMaxResults(limit);
        query.setFirstResult(page*limit);
        List<PostsEntity> results = query.list();
        return results;
    }

    public List<PostsEntity> getPostById(int postId){
        Query query = getSession().createQuery(
                "select t from PostsEntity t where t.postId = :postId ");
        query.setParameter("postId", postId);
        List<PostsEntity> results = query.list();
        return results;
    }

    public void delete(PostsEntity p){
        getSession().beginTransaction();
        getSession().delete(p);
        getSession().getTransaction().commit();
        getSession().flush();
    }

    public void deleteByTopicId(int topicId){
        Query query = getSession().createQuery("delete PostsEntity t where t.topicId = :topicId");
        query.setParameter("topicId", topicId);
        int count = query.executeUpdate();
        System.out.println("Number of record was deleted "+ count );
    }



        public void persist(PostsEntity postsEntity){
        try {
            getSession().beginTransaction();
            getSession().persist(postsEntity);
            getSession().getTransaction().commit();
        } catch (HibernateException e){
            getSession().getTransaction().rollback();
            throw e;
        } finally {
            getSession().flush();
        }
    }

    public void merge(PostsEntity postsEntity){
        try {
            getSession().beginTransaction();
            getSession().merge(postsEntity);
            getSession().getTransaction().commit();
        } catch (HibernateException e){
            getSession().getTransaction().rollback();
        } finally {
            getSession().flush();
        }
    }
}
