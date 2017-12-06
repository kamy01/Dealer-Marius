package com.dealer.services.interfaces;

import javax.ejb.Remote;
import java.util.Date;
@Remote
public interface AddCar {
    boolean isCarAdded(String name, String mark, String condition, String price, Date date, String color);
}
