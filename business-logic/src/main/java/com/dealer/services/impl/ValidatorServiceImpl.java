package com.dealer.services.impl;

import com.dealer.dao.impl.DealerDao;
import com.dealer.dao.interfaces.Validator;
import com.dealer.dto.Dealer;
import com.dealer.entities.DealerEntity;

class ValidatorServiceImpl implements Validator{

    private DealerDao dealerDao;

    ValidatorServiceImpl(){

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
}
