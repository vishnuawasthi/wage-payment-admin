package com.app.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class EmailIdValidator implements ConstraintValidator<EmailId, String> {

	private String regEx;

	@Override
	public void initialize(EmailId constraintAnnotation) {
		regEx = constraintAnnotation.regExp();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(value)) {
			return true;
		} else {
			return value.matches(regEx);
		}
	}

	private boolean checkFormat(String value, String regEx) {
		Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}
}
