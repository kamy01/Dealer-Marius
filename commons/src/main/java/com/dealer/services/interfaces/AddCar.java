package com.dealer.services.interfaces;

import java.util.Date;

public interface AddCar {
    boolean isCarAdded(String name, String mark, String color, String price, String condition, Date date);
}
