package com.classklap.beans;

/**
 * Car Details Bean Class having Car Number and Color.
 * @author gaurav
 *
 */
public class CarDetails {
	private String carNumber;
	private String carColor;
	private String slotNumber;
	
	public String getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}
	public String getCarNumber() {
		return carNumber;
	}
	
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	@Override
	public String toString() {
		return "CarDetails [carNumber=" + carNumber + ", carColor=" + carColor
				+ ", slotNumber=" + slotNumber + "]";
	}
}
