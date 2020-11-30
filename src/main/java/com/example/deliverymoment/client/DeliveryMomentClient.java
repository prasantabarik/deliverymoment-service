package com.example.deliverymoment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.deliverymoment.domain.DeliveryMoment;
@FeignClient(name = "deliveryMomentdata-service", url = "${deliveryMomentdata.url}")
public interface DeliveryMomentClient {
	
	@RequestMapping(method = RequestMethod.POST, value = "/deliveryMoment")
	public DeliveryMoment createDeliveryMoment(@RequestBody DeliveryMoment deliveryMoment);


	@RequestMapping(method = RequestMethod.PUT, value = "/deliveryMoment/{id}")
	public DeliveryMoment updateDeliveryMoment(@PathVariable("id")String id,@RequestBody DeliveryMoment deliveryMoment);

	@RequestMapping(method = RequestMethod.DELETE, value = "/deliveryMoment/{id}")
	public String deleteDeliveryMoment(@PathVariable("id")String id);

	
}
