package com.example.deliverymoment.client.domain;

public class DeliveryStream {
	
	private String streamNumber;
	
	private String streamName;

	public String getStreamNumber() {
		return streamNumber;
	}

	public void setStreamNumber(String streamNumber) {
		this.streamNumber = streamNumber;
	}

	public String getStreamName() {
		return streamName;
	}

	public void setStreamName(String streamName) {
		this.streamName = streamName;
	}

	@Override
	public String toString() {
		return "DeliveryStream [streamNumber=" + streamNumber + ", streamName=" + streamName + "]";
	}

}
