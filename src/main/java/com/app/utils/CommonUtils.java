package com.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.http.HttpStatus;

import com.app.dto.ApiErrorResponseEntity;

public class CommonUtils {

	public static Date convertStringToDate(String dateString, String dateFormatPattern) {

		Date date = null;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatPattern) {
		};

		try {
			date = simpleDateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	/*
	 * public static void main(String ...strings) { //MM-dd-yyyy System
	 * .out.println("convertStringToDate  : "+convertStringToDate("2019-08-31",
	 * "yyyy-MM-dd")); }
	 */
	
	public static  ApiErrorResponseEntity buildApiErrorResponseEntity(List<String> errors,HttpStatus status) {
		ApiErrorResponseEntity entity = new ApiErrorResponseEntity();
		entity.setDebugMessage("BAD_REQUEST");
		entity.setErrors(errors);
		entity.setMessage("BAD_REQUEST");
		entity.setStatus(status);
		return entity;

	}

}
