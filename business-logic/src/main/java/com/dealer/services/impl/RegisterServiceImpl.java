package com.dealer.services.impl;

import com.dealer.dao.impl.DealerDaoImpl;
import com.dealer.dto.Dealer;
import com.dealer.services.interfaces.Register;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@TransactionManagement(value= TransactionManagementType.BEAN)
@Stateless
public class RegisterServiceImpl implements Register {

    public boolean isCreated(String dealerName, String dealerPassword){
        boolean isCreated = false;


            Dealer possibleDealer = new Dealer(dealerName, dealerPassword);
            Dealer returnedDealer = new DealerDaoImpl().findDealer(possibleDealer);


            if (returnedDealer.getId() == -1) {
                isCreated = new DealerDaoImpl().createDealer(dealerName, dealerPassword);
            }

        return isCreated;
    }
}
