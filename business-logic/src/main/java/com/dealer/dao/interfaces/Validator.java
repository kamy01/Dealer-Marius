package com.dealer.dao.interfaces;

import com.dealer.dto.Dealer;
import com.dealer.entities.DealerEntity;

public interface Validator {
    Dealer getDealerFromDealerEntity(DealerEntity dealerEntity);
    Dealer findDealer(Dealer dealer);
    boolean createDealer(String dealerName, String dealerPassword);
}
