package com.dealer.com.dealer.utils;

import com.dealer.dto.Car;
import com.dealer.dto.Dealer;
import com.dealer.entities.CarEntity;
import com.dealer.entities.DealerEntity;
import https.www_w3schools.Condition;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Conversions {

    public static Dealer getDealerFromDealerEntity(DealerEntity dealerEntity) {
        return new Dealer(dealerEntity.getDealerEntityName(), dealerEntity.getDealerEntityPassword(),
                dealerEntity.getRole(), dealerEntity.getEntityId());
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

    public static Car getDtoCarFromImportCar(https.www_w3schools.Car car){
        BigDecimal price = car.getPrice();
        Condition condition = car.getCondition();

        if(price == null)
        {
            price = BigDecimal.valueOf(0);
        }
        else{
            price = car.getPrice();
        }

        if(condition == null){
            condition = Condition.fromValue("NEW");
        }
        else{
            condition = car.getCondition();
        }

        Car dtoCar =  new Car(car.getModel(), car.getBrand(), car.getColor(), price.toString(),
                condition.toString(), new Date());

        dtoCar.setId(car.getVid().intValue());

        return dtoCar;
    }
}
