package com.example.deliverymoment.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.deliverymoment.client.ReferenceDataClient;
import com.example.deliverymoment.client.domain.DeliveryStream;

public class StreamNumberValidator implements ConstraintValidator<CheckStreamNumberValid, Integer> {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ReferenceDataClient referenceDataClient;

	@Override
	public void initialize(CheckStreamNumberValid notEmptyFields) {
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		boolean isValid = false;
		try {
			List<DeliveryStream> deliveryStreamList = referenceDataClient.findDeliveryStream(value.toString());
			for (DeliveryStream d : deliveryStreamList) {
				if (d.getStreamNumber().equalsIgnoreCase(value.toString())) {
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
			context.buildConstraintViolationWithTemplate("Stream Number Field is not valid").addConstraintViolation();

			LOGGER.info(" After Adding Constraint " + context.toString());
		}
		return isValid;
	}

}
