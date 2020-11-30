package com.example.deliverymoment.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.deliverymoment.client.ReferenceDataClient;
import com.example.deliverymoment.client.domain.DeliveryChannel;

public class StoreNumberValidator implements ConstraintValidator<CheckStoreNumberValid, Integer> {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ReferenceDataClient referenceDataClient;

	@Override
	public void initialize(CheckStoreNumberValid notEmptyFields) {
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		boolean isValid = false;
		try {
			List<DeliveryChannel> deliveryChannelList = referenceDataClient.findDeliveryChannel(value.toString());
			for (DeliveryChannel d : deliveryChannelList) {
				if (d.getStoreNumber() == value.intValue()) {
					isValid = true;
					continue;
				} else {
					isValid = false;
				}
			}
		} catch (Exception e) {
			isValid = false;
		}
		if (!isValid) {
			LOGGER.info(" Before Adding Constraint " + context.toString());
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Store Number Field is not valid").addConstraintViolation();

			LOGGER.info(" After Adding Constraint " + context.toString());
		}
		return isValid;
	}
}
