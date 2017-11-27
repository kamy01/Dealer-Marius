package com.dealer.dao.interfaces;

import com.dealer.entities.DealerEntity;

public interface Dao {
    boolean createDealerEntity(String dealerName, String dealerPassword);
    void deleteDealerEntity(String dealerName);
    DealerEntity getDealerEntity(String dealerName);
}
