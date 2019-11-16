package com.classklap.service;

import java.util.Collection;
import java.util.List;
import com.classklap.beans.CarDetails;

public interface ParkingService {

	String createParkinglot(int size);
	String parkCar(CarDetails carDetails);
	String leave(int slot);
	Collection<CarDetails> status();
	List<String> regNofilterByColor(String color);
	List<String> slotNofilterByColor(String color);
	String filterByRegNo(String regno);
	
}
