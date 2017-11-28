package com.dealer.services.interfaces;

import javax.ejb.Remote;
import java.util.Date;
@Remote
public interface AddCar {
    boolean isCarAdded(String name, String mark, String color, String price, String condition, Date date);
}
