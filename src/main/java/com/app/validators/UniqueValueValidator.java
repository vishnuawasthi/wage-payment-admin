package com.app.validators;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.app.dao.ClientDAO;
import com.app.entities.ClientConfig;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String> {

	@Autowired
	private ClientDAO clientDAO;

	private String propertyName;

	@Override
	public void initialize(UniqueValue uniqueValue) {
		propertyName = uniqueValue.property();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		List<ClientConfig> list = clientDAO.findByUniqueKey(propertyName, value);
		return CollectionUtils.isEmpty(list);
	}

}
