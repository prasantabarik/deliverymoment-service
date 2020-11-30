package com.example.deliverymoment.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.deliverymoment.client.ReferenceDataClient;
import com.example.deliverymoment.client.domain.Deliverer;

public class DelivererValidator implements ConstraintValidator<CheckDelivererValid, Integer> {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ReferenceDataClient referenceDataClient;

	@Override
    public void initialize(CheckDelivererValid notEmptyFields) {
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
    	boolean isValid = false;
    		try {
    			List<Deliverer> delivererList = referenceDataClient.getDeliverer(value.toString());
    			for(Deliverer d: delivererList) {
    				if(d.getDelivererNumber().equalsIgnoreCase(value.toString())) {
    					isValid = true;
    					continue;
    				}else {
    					isValid = false;
    				}
    			}
    		}catch(Exception e) {
    			isValid = false;	
    		}
    	if ( !isValid ) {
    		LOGGER.info(" Before Adding Constraint "+context.toString());
    		context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Deliverer Field is not valid")
            .addConstraintViolation();
            
            LOGGER.info(" After Adding Constraint "+context.toString());
        }
    	return isValid;
    }

}
