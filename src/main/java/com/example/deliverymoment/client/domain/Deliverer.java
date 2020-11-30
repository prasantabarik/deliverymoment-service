package com.example.deliverymoment.client.domain;

public class Deliverer {
	
	private String delivererNumber;

	public String getDelivererNumber() {
		return delivererNumber;
	}

	public void setDelivererNumber(String delivererNumber) {
		this.delivererNumber = delivererNumber;
	}

	@Override
	public String toString() {
		return "Deliverer [delivererNumber=" + delivererNumber + "]";
	}
}
