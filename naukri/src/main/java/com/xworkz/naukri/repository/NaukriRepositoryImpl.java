package com.xworkz.naukri.repository;

import com.xworkz.naukri.entity.NaukriEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
public class NaukriRepositoryImpl implements NaukriRepository{

    @Autowired
    EntityManagerFactory entityManagerFactory;




    @Override
    public boolean saveData(NaukriEntity naukriEntity) {
        System.out.println("user Entered data is been saved in DB : " + naukriEntity);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(naukriEntity);
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
    public List<NaukriEntity> getUserData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("readAllData");
            List<NaukriEntity> list = (List<NaukriEntity>) query.getResultList();
            System.out.println(list);
            return list;
        } catch (Exception e) {
            return Collections.emptyList();
        }finally {
            entityManager.close();
        }
    }

    @Override
    public NaukriEntity getDetailsBasedOnEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            Query query = entityManager.createNamedQuery("readEmail");
            query.setParameter("emailId",email);
            NaukriEntity naukri =(NaukriEntity) query.getSingleResult();
            return naukri;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public NaukriEntity getDetailsBasedOnMobileNumber(Long mobileNumber) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            Query query = entityManager.createNamedQuery("readmobile");
            query.setParameter("phoneNumber",mobileNumber);
            NaukriEntity naukri =(NaukriEntity) query.getSingleResult();
            return naukri;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public NaukriEntity getDetailsBasedOnId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            NaukriEntity naukri = entityManager.find(NaukriEntity.class, id);
            return naukri;
        } catch (Exception e) {
            System.out.println("Exception in the Data  " + e.getMessage());
            return null;
        }finally {
            entityManager.close();
        }
    }
}
