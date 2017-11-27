package com.dealer.services.interfaces;

import javax.ejb.Remote;

@Remote
public interface Register {
    boolean isCreated(String dealerName, String dealerPassword);
}
