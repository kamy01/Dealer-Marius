package com.dealer.services.impl;

import com.dealer.services.interfaces.AddCar;

import javax.ejb.Stateless;
import java.util.Date;

@Stateless
public class AddCarServiceImpl implements AddCar {
    public boolean isCarAdded(String name, String mark, String color, String price, String condition, Date date) {
        return new AddCarValidatorServiceImpl().createCar(name, mark, color, price, condition, date);
    }
}
