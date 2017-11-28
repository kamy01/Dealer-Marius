package com.dealer.dao.interfaces;

import com.dealer.dto.Car;
import com.dealer.dto.Dealer;
import com.dealer.entities.CarEntity;
import com.dealer.entities.DealerEntity;

public interface Validator {
    Dealer getDealerFromDealerEntity(DealerEntity dealerEntity);
    Dealer findDealer(Dealer dealer);
    boolean createDealer(String dealerName, String dealerPassword);

    Car getCarFromCarEntity(CarEntity carEntity);
    Car findCar(Car car);
    boolean createCar(String name, String mark, String color, String price, String condition, String date);
}
