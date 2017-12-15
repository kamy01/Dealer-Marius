package com.dealer.services.impl;

import com.dealer.dao.impl.DealerDaoImpl;
import com.dealer.dto.Dealer;
import com.dealer.services.interfaces.Login;
import com.dealer.utils.Utils;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import java.util.HashMap;
import java.util.Map;

@TransactionManagement(value= TransactionManagementType.BEAN)
@Stateless
public class LoginServiceImpl implements Login {

     public Map<Integer, Dealer> getResponse(String dealerName, String dealerPassword){
        Map<Integer,Dealer> responseMap = new HashMap<Integer, Dealer>();
        Dealer possibleDealer = new Dealer(dealerName, dealerPassword);
        Dealer returnedDealer = new DealerDaoImpl().findDealer(possibleDealer);

        if (returnedDealer.getId() == -1){
            responseMap.put(Utils.NOT_FOUND, returnedDealer);
        }

        else
        {

            if(!returnedDealer.getDealerPassword().equals(dealerPassword)){
                responseMap.put(Utils.UNAUTHORIZED, returnedDealer);
            }
            else{
                responseMap.put(Utils.SUCCESS, returnedDealer);
            }
        }

        return responseMap;
    }
}
