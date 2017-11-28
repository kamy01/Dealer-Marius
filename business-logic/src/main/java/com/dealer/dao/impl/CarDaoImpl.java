package com.dealer.dao.impl;

import com.dealer.dao.interfaces.CarDao;
import com.dealer.entities.CarEntity;

import javax.persistence.*;
import java.util.Date;

public class CarDaoImpl implements CarDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("DealerPersistenceUnit");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();


    @Override
    public boolean createCarEntity(String name, String mark, String color, String price, String condition, Date date) {


        CarEntity newCar = new CarEntity(name, mark, color, price, condition, date);

        tx.begin();
        em.persist(newCar);
        tx.commit();

        return true;

    }

    @Override
    public void deleteCarEntity(int id, int ownerId) {

    }

    @Override
    public CarEntity getCarEntity(int id) {
        CarEntity carEntity = new CarEntity();

        try {
            Query getDealerQuery = em.createNamedQuery("CarEntity.findCar")
                    .setParameter("id", id);

            carEntity = (CarEntity) getDealerQuery.getSingleResult();
        }

        catch (NoResultException e){
            System.out.println("com.dealer.dto.Dealer not found !");
            carEntity.setId(-1);
        }

        return carEntity;
    }
}
