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
    public boolean isCarAdded(String name, String mark, String color, String price, String condition, Date date) {
        return new CarDaoImpl().createCar(name, mark, color, price, condition, date);
    }
}
