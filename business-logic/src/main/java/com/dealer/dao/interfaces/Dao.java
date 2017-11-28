package com.dealer.dao.interfaces;

import com.dealer.entities.CarEntity;
import com.dealer.entities.DealerEntity;

public interface Dao {
    boolean createDealerEntity(String dealerName, String dealerPassword);
    void deleteDealerEntity(String dealerName);
    DealerEntity getDealerEntity(String dealerName);

    boolean createCarEntity(String name, String mark, String color, String price, String condition, String date);
    void deleteCarEntity(int id, int ownerId);
    CarEntity getCarEntity(int id);
}
