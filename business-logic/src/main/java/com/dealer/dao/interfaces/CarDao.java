package com.dealer.dao.interfaces;

import com.dealer.dto.Car;
import com.dealer.entities.CarEntity;

import java.util.Date;
import java.util.List;

public interface CarDao {

    boolean createCarEntity(String name, String mark, String condition, String price, Date date, String color);
    boolean createImportCarEntity(int vid, String name, String mark, String condition, String price, Date date,
                                  String color);
    void deleteCarEntity(int id);
    CarEntity getCarEntity(int id);
    List<CarEntity> getAllCars();
    List<CarEntity> filterCars(String name, String mark, String condition, String price, Date date, String color);

    Car findCar(Car car);
    boolean createCar(String name, String mark, String condition, String price, Date date, String color);
}
