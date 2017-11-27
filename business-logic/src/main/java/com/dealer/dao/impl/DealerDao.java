package com.dealer.dao.impl;

import com.dealer.dao.interfaces.Dao;
import com.dealer.entities.DealerEntity;

import javax.persistence.*;

public class DealerDao implements Dao{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("DealerPersistenceUnit");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
    public boolean createDealerEntity(String dealerName, String dealerPassword){
        boolean isCreated = false;

        if(getDealerEntity(dealerName).getEntityId() == -1) {

            DealerEntity newDealer = new DealerEntity();
            newDealer.setDealerEntityName(dealerName);
            newDealer.setDealerEntityPassword(dealerPassword);

            tx.begin();
            em.persist(newDealer);
            tx.commit();

            isCreated = true;
        }

        return isCreated;
    }

    public void deleteDealerEntity(String dealerName){
        DealerEntity dealerEntity = em.find(DealerEntity.class, dealerName);
        if(dealerEntity != null){

            tx.begin();
            em.remove(dealerEntity);
            tx.commit();
        }

    }


    public DealerEntity getDealerEntity(String dealerName){
        DealerEntity dealerEntity = new DealerEntity();

        try {
            Query getDealerQuery = em.createNamedQuery("DealerEntity.findDealer")
                    .setParameter("name", dealerName);

            dealerEntity = (DealerEntity) getDealerQuery.getSingleResult();
        }

        catch (NoResultException e){
            System.out.println("com.dealer.dto.Dealer not found !");
            dealerEntity.setEntityId(-1);
        }

        return dealerEntity;

    }

//    public ArrayList<com.dealer.entities.DealerEntity> getDealersEntities(){
//        em.createQuery("SELECT d from com.dealer.entities.DealerEntity d");
//    }
}
