package com.dealer.com.dealer.utils;

import com.dealer.dto.Car;
import com.dealer.dto.Dealer;
import com.dealer.entities.CarEntity;
import com.dealer.entities.DealerEntity;

import java.util.ArrayList;
import java.util.List;


public class Conversions {

    public static Dealer getDealerFromDealerEntity(DealerEntity dealerEntity) {
        return new Dealer(dealerEntity.getDealerEntityName(), dealerEntity.getDealerEntityPassword(),
                dealerEntity.getEntityId());
    }

    public static Car getCarFromCarEntity(CarEntity carEntity) {
        return new Car(carEntity.getName(), carEntity.getMark(), carEntity.getCondition(), carEntity.getColor(),
                carEntity.getPrice(), carEntity.getRegistrationDate());
    }

    public static List<Car> getCarsFromCarsEntities(List<CarEntity> carEntities){
        List<Car> cars = new ArrayList<Car>();

        for (CarEntity c :
                carEntities) {

            Car currentCar = new Car(c.getName(), c.getMark(), c.getColor(), c.getPrice(), c.getCondition(),
                    c.getRegistrationDate());

            cars.add(currentCar);
        }

        return cars;
    }

}
