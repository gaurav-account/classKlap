package com.classklap.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.classklap.beans.CarDetails;
import com.classklap.service.ParkingService;

public class ParkingServiceImpl implements ParkingService{
	List<Integer> parkingslots = new ArrayList<>();
	Map<Integer, CarDetails> carParkingMap = new HashMap<>();
	
    
	@Override
	public String createParkinglot(int size) {
		for(int i=1; i<=size ; i++){
			parkingslots.add(i);
		}
		return "Created a Parking lot with "+size+" slots.";
	}

	@Override
	public String parkCar(CarDetails carDetails) {
		Iterator<Integer> itr = parkingslots.iterator();
		if(itr.hasNext()){
			Integer slot = itr.next();
			carDetails.setSlotNumber(slot.toString());
			carParkingMap.put(slot, carDetails);
			itr.remove();
			return "Allocated Slot Number "+slot;
			
		}	
		return "Sorry, Parking Lot is full.";
	}

	@Override
	public String leave(int slot) {
		parkingslots.add(slot);
		carParkingMap.remove(slot);
		return "Slot Number "+slot+" is free.";
		
	}

	@Override
	public Collection<CarDetails> status() {		
		return carParkingMap.values();
	}

	@Override
	public List<String> regNofilterByColor(String color) {
		List<String> regnos = new ArrayList<String>();
		for(CarDetails carDetails:carParkingMap.values()){
			if(carDetails.getCarColor().equalsIgnoreCase(color)){
				regnos.add(carDetails.getCarNumber());
			}
		}
		return regnos;
	}
	@Override
	public List<String> slotNofilterByColor(String color) {
		List<String> slotnos = new ArrayList<String>();
		for(CarDetails carDetails:carParkingMap.values()){
			if(carDetails.getCarColor().equalsIgnoreCase(color)){
				slotnos.add(carDetails.getSlotNumber());
			}
		}
		return slotnos;
	}

	@Override
	public String filterByRegNo(String regno) {
		String slotno = new String();
		for(CarDetails carDetails:carParkingMap.values()){
			if(carDetails.getCarNumber().equalsIgnoreCase(regno)){
				slotno = carDetails.getSlotNumber();
			}
		}
		return slotno;
	}

}
