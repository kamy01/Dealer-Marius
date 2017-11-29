package com.dealer.com.dealer.utils;

import com.dealer.dto.Car;
import com.dealer.dto.Dealer;
import com.dealer.entities.CarEntity;
import com.dealer.entities.DealerEntity;


public class Conversions {

    public static Dealer getDealerFromDealerEntity(DealerEntity dealerEntity) {
        return new Dealer(dealerEntity.getDealerEntityName(), dealerEntity.getDealerEntityPassword(),
                dealerEntity.getEntityId());
    }

    public static Car getCarFromCarEntity(CarEntity carEntity) {
        return new Car(carEntity.getName(), carEntity.getMark(), carEntity.getCondition(), carEntity.getColor(),
                carEntity.getPrice(), carEntity.getRegistrationDate());
    }

}
