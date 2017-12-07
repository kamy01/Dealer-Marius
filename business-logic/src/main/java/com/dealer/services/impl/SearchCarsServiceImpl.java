package com.dealer.services.impl;

import com.dealer.com.dealer.utils.Conversions;
import com.dealer.dao.impl.CarDaoImpl;
import com.dealer.dto.Car;
import com.dealer.services.interfaces.SearchCars;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import java.util.List;
@TransactionManagement(value= TransactionManagementType.BEAN)
@Stateless
public class SearchCarsServiceImpl implements SearchCars{

    @Override
    public List<Car> getCars() {
        return Conversions.getCarsFromCarsEntities(new CarDaoImpl().getAllCars());
    }
}
