package com.dealer.services.impl;

import com.dealer.dto.Dealer;
import com.dealer.services.interfaces.Login;
import com.dealer.utils.Utils;
import javax.ejb.Stateless;

@Stateless
public class LoginServiceImpl implements Login {

     public int getResponseCode(String dealerName, String dealerPassword){

        Dealer possibleDealer = new Dealer(dealerName, dealerPassword);
        Dealer returnedDealer = new ValidatorService().findDealer(possibleDealer);

        if (returnedDealer.getId() == -1){
            return Utils.NOT_FOUND;
        }

        else
        {

            if(!returnedDealer.getDealerPassword().equals(dealerPassword)){
                return Utils.UNAUTHORIZED;
            }
            else{
                return Utils.SUCCESS;
            }
        }
    }
}
