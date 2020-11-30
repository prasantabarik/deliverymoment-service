package com.example.deliverymoment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.deliverymoment.client.DeliveryMomentClient;
import com.example.deliverymoment.client.ReferenceDataClient;
import com.example.deliverymoment.domain.DeliveryMoment;

@Component
public class DeliveryMomentService {
	
	@Autowired
	DeliveryMomentClient deliveryMomentClient;
	
	@Autowired
	ReferenceDataClient referenceDataClient;

	public DeliveryMoment createDeliveryMoment(DeliveryMoment deliveryMoment) {
		return deliveryMomentClient.createDeliveryMoment(deliveryMoment);
	}
	
	public DeliveryMoment updateDeliveryMoment(String id, DeliveryMoment deliveryMoment) {
		return deliveryMomentClient.updateDeliveryMoment(id, deliveryMoment);
	}
	
	public String deleteDeliveryMoment(String id) {
		return deliveryMomentClient.deleteDeliveryMoment(id);
	}
	
	public List<DeliveryMoment> findDeliveryMoment(String storeNumber,String streamNumber, String delivererNumber) {
		return referenceDataClient.findDeliveryMoment(storeNumber, streamNumber, delivererNumber);
	}
	
}
