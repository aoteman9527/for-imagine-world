package com.imagine.world.dao;

import com.imagine.world.customdaosupport.CustomDAOSupport;
import com.imagine.world.models.MyproductEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by letuan on 5/27/14.
 */
public class MyproductDao extends CustomDAOSupport implements Serializable {

    public void insert(MyproductEntity arg0){
        try {
            getDAOManager().beginTransaction();
            getDAOManager().persist(arg0);
            getDAOManager().getTransaction().commit();
        } catch (HibernateException e){
            getDAOManager().getTransaction().rollback();
            getDAOManager().flush();
        }
    }

    public void update(MyproductEntity arg0){
        try {
            getDAOManager().beginTransaction();
            getDAOManager().merge(arg0);
            getDAOManager().getTransaction().commit();
        } catch (HibernateException e){
            getDAOManager().getTransaction().rollback();
        }


    }

    public List<MyproductEntity> getProductByProductCode(String productCode){

        Query query = getDAOManager().createQuery(" select t from MyproductEntity t where t.productCode = :productCode ");

        query.setParameter("productCode", productCode);


        List<MyproductEntity> results = query.list();

        if (results !=null && results.size() > 0) {
            return results;
        }

        return null;
    }

}
