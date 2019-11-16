package com.classklap.main;

import java.util.Scanner;
import com.classklap.beans.CarDetails;
import com.classklap.service.ParkingService;
import com.classklap.service.impl.ParkingServiceImpl;

/**
 * Main Class which displays menu and take user input and provide respective output.
 * @author gaurav
 *
 */
public class MainMenu {

	public static void main(String[] args) {
	
	//This can injected using spring framework.
	ParkingService parkingService = new ParkingServiceImpl();
		
	Scanner input = new Scanner(System.in);
		
	for(;;){
		System.out.println("\n");
		System.out.println("Please enter input from command prompt \n(options: create_parking_lot,park,leave,status,registration_numbers_for_cars_with_colour,slot_numbers_for_cars_with_colour,slot_number_for_registration_number):\nThen provide required parameters. ");
		System.out.println("\n");

        String option = input.next();  
      
      
		 switch (option) {
		    case "create_parking_lot":	
				System.out.println("\n");
		        Integer noOfSlots = input.nextInt();   
				System.out.println(noOfSlots);
				System.out.println(parkingService.createParkinglot(noOfSlots));
		      break;
		      
		    case "park":
				System.out.println("\n");
				String carNumber  = input.next();  
			    String carColor  = input.next();  
				System.out.println(carNumber+" "+carColor);	
				CarDetails carDetails = new CarDetails();
				carDetails.setCarColor(carColor);
				carDetails.setCarNumber(carNumber);
				System.out.println(parkingService.parkCar(carDetails));
		      break;
		      
		    case "leave":
				System.out.println("\n");
				Integer slot = input.nextInt();
				System.out.println(slot);
				System.out.println(parkingService.leave(slot));
		      break;
		      
		    case "status":
				System.out.println("\n");
				System.out.println(parkingService.status());
		      break;
		      
		    case "registration_numbers_for_cars_with_colour":
				System.out.println("\n");
				String color = input.next();
				System.out.println(color);
				System.out.println(parkingService.regNofilterByColor(color));
		      break;
		      
		    case "slot_numbers_for_cars_with_colour":
				System.out.println("\n");
				String color1 = input.next();
				System.out.println(color1);
				System.out.println(parkingService.slotNofilterByColor(color1));
		      break;
		      
		    case "slot_number_for_registration_number":
				System.out.println("\n");
				String regno = input.next();
				System.out.println(regno);
				System.out.println(parkingService.filterByRegNo(regno));
		      break;
		      
		    default:
		      System.out.println("Invalid selection");
		      break; // This break is not really necessary
		    }
	}

	}
	


}
