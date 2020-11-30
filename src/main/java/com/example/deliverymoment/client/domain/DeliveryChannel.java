package com.example.deliverymoment.client.domain;

public class DeliveryChannel {
	
	private int streamNumber;
	
	private int storeNumber;
	
	private String startDate;
	
	private String endDate;
	
	private int delivererNumber;

	public int getDelivererNumber() {
		return delivererNumber;
	}

	public void setDelivererNumber(int delivererNumber) {
		this.delivererNumber = delivererNumber;
	}

	public int getStreamNumber() {
		return streamNumber;
	}

	public void setStreamNumber(int streamNumber) {
		this.streamNumber = streamNumber;
	}

	public int getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "DeliveryChannel [streamNumber=" + streamNumber + ", storeNumber=" + storeNumber + ", startDate="
				+ startDate + ", endDate=" + endDate + ", delivererNumber=" + delivererNumber + "]";
	}

	
}
