package com.example.deliverymoment.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateFormatValidator implements ConstraintValidator<CheckDateFormat, String> {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Override
    public void initialize(CheckDateFormat notEmptyFields) {
    }

    @Override
    public boolean isValid(String objects, ConstraintValidatorContext context) {
    	boolean isValid = false;
    	if(StringUtils.isEmpty(objects)){
    		isValid = false;
    	}else {
    		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		try {
    			Date value = df.parse(objects);
    			LOGGER.info(" value "+value);
    			isValid = true;
    		} catch (ParseException e) {
    			LOGGER.info(" Exception "+e.getMessage());
    			isValid = false;
			}
    	}
    	if ( !isValid ) {
    		LOGGER.info(" Before Adding Constraint "+context.toString());
    		context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Date Field is not valid")
            .addConstraintViolation();
            
            LOGGER.info(" After Adding Constraint "+context.toString());
        }
    	return isValid;
    }

}