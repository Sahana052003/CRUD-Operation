package com.xworkz.bigbasket.dao;

import com.xworkz.bigbasket.entity.BigBasketEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
public class BigBasketDAOImpl implements BigBasketDAO {
    @Autowired
    EntityManagerFactory entityManagerFactory;


    @Override
    public boolean saveUserEnteredData(BigBasketEntity bigBasketEntity) {
        System.out.println("user Entered data is been saved in DB : " + bigBasketEntity);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(bigBasketEntity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<BigBasketEntity> getData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("readAllData");
            List<BigBasketEntity> list = (List<BigBasketEntity>) query.getResultList();
            System.out.println(list);
            return list;
        } catch (Exception e) {
            return Collections.emptyList();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public BigBasketEntity getDataBasedOnEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            Query query = entityManager.createNamedQuery("readEmail");
            query.setParameter("gmail", email);
            BigBasketEntity bigBasketEntity = (BigBasketEntity) query.getSingleResult();
            return bigBasketEntity;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public BigBasketEntity getDataBasedOnMobileNumber(Long phoneNumber) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            Query query = entityManager.createNamedQuery("readmobile");
            query.setParameter("mobileNumber", phoneNumber);
            BigBasketEntity bigBasketEntity = (BigBasketEntity) query.getSingleResult();
            return bigBasketEntity;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public BigBasketEntity getDetailsBasedOnId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            BigBasketEntity bigBasketEntity = entityManager.find(BigBasketEntity.class, id);
            return bigBasketEntity;
        } catch (Exception e) {
            System.out.println("Exception in the Data  " + e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }
}