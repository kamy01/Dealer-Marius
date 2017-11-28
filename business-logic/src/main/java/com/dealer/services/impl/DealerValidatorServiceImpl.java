package com.dealer.services.impl;

import com.dealer.dao.impl.DealerDao;
import com.dealer.dao.interfaces.Validator;
import com.dealer.dto.Car;
import com.dealer.dto.Dealer;
import com.dealer.entities.CarEntity;
import com.dealer.entities.DealerEntity;

class DealerValidatorServiceImpl implements Validator{

    private DealerDao dealerDao;

    DealerValidatorServiceImpl(){

        dealerDao = new DealerDao();
    }

    public Dealer getDealerFromDealerEntity(DealerEntity dealerEntity){
        return new Dealer(dealerEntity.getDealerEntityName(), dealerEntity.getDealerEntityPassword(),
                dealerEntity.getEntityId());
    }

    public Dealer findDealer(Dealer dealer){
        DealerEntity foundDealer = dealerDao.getDealerEntity(dealer.getDealerName());
        return getDealerFromDealerEntity(foundDealer);

    }

    public boolean createDealer(String dealerName, String dealerPassword){
        boolean isCreated;

        isCreated = dealerDao.createDealerEntity(dealerName, dealerPassword);
        return isCreated;
    }

    @Override
    public Car getCarFromCarEntity(CarEntity carEntity) {
        return null;
    }

    @Override
    public Car findCar(Car car) {
        return null;
    }

    @Override
    public boolean createCar(String name, String mark, String color, String price, String condition, String date) {
        return false;
    }
}
