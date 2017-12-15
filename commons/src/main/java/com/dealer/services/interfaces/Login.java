package com.dealer.services.interfaces;

import com.dealer.dto.Dealer;

import javax.ejb.Remote;
import java.util.Map;

@Remote
public interface Login {
    Map<Integer,Dealer> getResponse(String dealerName, String dealerPassword);
}
