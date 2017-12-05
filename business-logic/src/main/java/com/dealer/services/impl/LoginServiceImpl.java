package com.dealer.services.impl;

import com.dealer.dao.impl.DealerDaoImpl;
import com.dealer.dto.Dealer;
import com.dealer.services.interfaces.Login;
import com.dealer.utils.Utils;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@TransactionManagement(value= TransactionManagementType.BEAN)
@Stateless
public class LoginServiceImpl implements Login {

     public int getResponseCode(String dealerName, String dealerPassword){

        Dealer possibleDealer = new Dealer(dealerName, dealerPassword);
        Dealer returnedDealer = new DealerDaoImpl().findDealer(possibleDealer);

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
