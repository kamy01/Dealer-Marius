package com.dealer.services.impl;

import com.dealer.dao.impl.DealerDaoImpl;
import com.dealer.dao.interfaces.DealerValidator;
import com.dealer.dto.Car;
import com.dealer.dto.Dealer;
import com.dealer.entities.CarEntity;
import com.dealer.entities.DealerEntity;

class DealerValidatorServiceImpl implements DealerValidator {

    private DealerDaoImpl dealerDao;

    DealerValidatorServiceImpl(){

        dealerDao = new DealerDaoImpl();
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

}
