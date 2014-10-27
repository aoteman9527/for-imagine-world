package com.imagine.world.dao;

import com.imagine.world.customdaosupport.CustomDAOSupport;
import com.imagine.world.models.PostsEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tuanlhd on 10/27/14.
 */
public class PostDAO extends CustomDAOSupport implements Serializable {
    public List<PostsEntity> getForumById(int postId){

        Query query = getSession().createQuery(" select t from PostsEntity t where t.postId = :postId ");

        query.setParameter("postId", postId);

        List<PostsEntity> results = query.list();
        return results;
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
