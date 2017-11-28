package com.dealer.dao.interfaces;

import com.dealer.entities.DealerEntity;


public interface DealerDao {
    boolean createDealerEntity(String dealerName, String dealerPassword);
    void deleteDealerEntity(String dealerName);
    DealerEntity getDealerEntity(String dealerName);
}
