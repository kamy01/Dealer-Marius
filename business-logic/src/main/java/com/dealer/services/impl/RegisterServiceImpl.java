package com.dealer.services.impl;

import com.dealer.dto.Dealer;
import com.dealer.services.interfaces.Register;

import javax.ejb.Stateless;

@Stateless
public class RegisterServiceImpl implements Register {

    public boolean isCreated(String dealerName, String dealerPassword){
        boolean isCreated = false;


            DealerValidatorServiceImpl validator = new DealerValidatorServiceImpl();
            Dealer possibleDealer = new Dealer(dealerName, dealerPassword);
            Dealer returnedDealer = validator.findDealer(possibleDealer);


            if (returnedDealer.getId() == -1) {
                isCreated = validator.createDealer(dealerName, dealerPassword);
            }

        return isCreated;
    }
}
