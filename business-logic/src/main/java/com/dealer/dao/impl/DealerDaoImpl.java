package com.dealer.dao.impl;

import com.dealer.com.dealer.utils.Conversions;
import com.dealer.dao.interfaces.DealerDao;
import com.dealer.dto.Dealer;
import com.dealer.entities.DealerEntity;

import javax.persistence.*;

public class DealerDaoImpl implements DealerDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("DealerPersistenceUnit");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
    public boolean createDealerEntity(String dealerName, String dealerPassword, String role){
        boolean isCreated = false;

        if(getDealerEntity(dealerName).getEntityId() == -1) {

            DealerEntity newDealer = new DealerEntity();
            newDealer.setDealerEntityName(dealerName);
            newDealer.setDealerEntityPassword(dealerPassword);
            newDealer.setRole(role);

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

    @Override
    public Dealer findDealer(Dealer dealer) {
        DealerEntity foundDealer = this.getDealerEntity(dealer.getDealerName());
        return Conversions.getDealerFromDealerEntity(foundDealer);
    }

    @Override
    public boolean createDealer(String dealerName, String dealerPassword, String role) {
        boolean isCreated;

        isCreated = this.createDealerEntity(dealerName, dealerPassword, role);
        return isCreated;
    }

}
