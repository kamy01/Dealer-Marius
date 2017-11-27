package com.dealer.services.impl;

import com.dealer.dto.Dealer;
import com.dealer.services.interfaces.Register;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

@Stateless
public class RegisterServiceImpl implements Register {

    public boolean isCreated(String dealerName, String dealerPassword){
        boolean isCreated = false;

        if(!dealerName.isEmpty() && !dealerPassword.isEmpty()) {

            ValidatorService validator = new ValidatorService();
            Dealer possibleDealer = new Dealer(dealerName, dealerPassword);
            Dealer returnedDealer = validator.findDealer(possibleDealer);


            if (returnedDealer.getId() == -1) {
                isCreated = validator.createDealer(dealerName, dealerPassword);
            }
        }

        return isCreated;
    }
}
