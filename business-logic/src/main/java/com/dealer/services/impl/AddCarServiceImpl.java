package com.dealer.services.impl;

import com.dealer.dao.impl.CarDaoImpl;
import com.dealer.services.interfaces.AddCar;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import java.util.Date;
@TransactionManagement(value= TransactionManagementType.BEAN)
@Stateless
public class AddCarServiceImpl implements AddCar {

    public boolean isCarAdded(String name, String mark, String condition, String price, Date date, String color) {
        return new CarDaoImpl().createCar(name, mark, condition, price, date, color);
    }
}
