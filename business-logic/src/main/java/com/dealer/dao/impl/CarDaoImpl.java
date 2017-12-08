package com.dealer.dao.impl;

import com.dealer.com.dealer.utils.Conversions;
import com.dealer.dao.interfaces.CarDao;
import com.dealer.dto.Car;
import com.dealer.entities.CarEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class CarDaoImpl implements CarDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("DealerPersistenceUnit");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();


    @Override
    public boolean createCarEntity(String name, String mark, String condition, String price, Date date, String color) {


        CarEntity newCar = new CarEntity(name, mark, color, price, condition, date);

        tx.begin();
        em.persist(newCar);
        tx.commit();

        return true;

    }

    @Override
    public void deleteCarEntity(int id) {

    }

    @Override
    public CarEntity getCarEntity(int id) {
        CarEntity carEntity = new CarEntity();

        try {
            Query getCarQuery = em.createNamedQuery("CarEntity.findCar")
                    .setParameter("id", id);

            carEntity = (CarEntity) getCarQuery.getSingleResult();
        }

        catch (NoResultException e){
            System.out.println("com.dealer.dto.Car not found !");
            carEntity.setId(-1);
        }

        return carEntity;
    }

    @Override
    public List<CarEntity> getAllCars() {

        Query getCarsQuery = em.createNamedQuery("CarEntity.getAllCars");

        return getCarsQuery.getResultList();

    }

    @Override
    public Car findCar(Car car) {
        CarEntity foundCar = this.getCarEntity(car.getId());
        return Conversions.getCarFromCarEntity(foundCar);
    }

    @Override
    public boolean createCar(String name, String mark, String condition, String price, Date date, String color) {
        boolean isCreated;

        isCreated = this.createCarEntity(name, mark, condition, price, date, color);
        return isCreated;
    }
}
