package com.dealer.dao.interfaces;

import com.dealer.entities.CarEntity;

import java.util.Date;

public interface CarDao {

    boolean createCarEntity(String name, String mark, String color, String price, String condition, Date date);
    void deleteCarEntity(int id, int ownerId);
    CarEntity getCarEntity(int id);
}
