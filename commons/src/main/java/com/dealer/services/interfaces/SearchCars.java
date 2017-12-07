package com.dealer.services.interfaces;

import com.dealer.dto.Car;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface SearchCars {
    List<Car> getCars();
}
