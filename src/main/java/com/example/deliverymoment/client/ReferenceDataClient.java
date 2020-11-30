package com.example.deliverymoment.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.deliverymoment.client.domain.Deliverer;
import com.example.deliverymoment.client.domain.DeliveryChannel;
import com.example.deliverymoment.client.domain.DeliveryStream;
import com.example.deliverymoment.domain.DeliveryMoment;

@FeignClient(name = "referencedata-service", url = "${referencedata.url}")
public interface ReferenceDataClient {

	@RequestMapping(method = RequestMethod.GET, value = "/deliverer/{delivererNumber}")
	public List<Deliverer> getDeliverer(@PathVariable("delivererNumber") String delivererNumber);

	@RequestMapping(method = RequestMethod.GET, value = "/deliveryChannel/{storeNumber}")
	public List<DeliveryChannel> findDeliveryChannel(@PathVariable("storeNumber") String storeNumber);

	@RequestMapping(method = RequestMethod.GET, value = "/deliveryStream/{streamNumber}")
	public List<DeliveryStream> findDeliveryStream(@PathVariable("streamNumber") String streamNumber);

	@RequestMapping(method = RequestMethod.GET, value = "/deliveryMomement/findBy")
	public List<DeliveryMoment> findDeliveryMoment(@RequestParam("storeNumber") String storeNumber,
			@RequestParam("streamNumber") String streamNumber, @RequestParam("delivererNumber") String delivererNumber);

}
