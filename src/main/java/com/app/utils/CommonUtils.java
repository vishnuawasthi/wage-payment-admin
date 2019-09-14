package com.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import com.app.dto.ApiErrorResponseEntity;
import com.app.dto.ClientConfigDTO;
import com.app.entities.ClientConfig;

public class CommonUtils {

	public static Date convertStringToDate(String dateString, String dateFormatPattern) {

		Date date = null;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatPattern) {
		};

		if(!StringUtils.isEmpty(dateString)) {
			try {
				date = simpleDateFormat.parse(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return date;
	}
	
	
	public static String convertDateToString(Date fromDate, String dateFormatPattern) {
		String dateString = null;
		if(!StringUtils.isEmpty(fromDate)) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatPattern);
			dateString = simpleDateFormat.format(fromDate);
		}
		return dateString;
	}
	
	

	/*
	 * public static void main(String ...strings) { //MM-dd-yyyy System
	 * .out.println("convertStringToDate  : "+convertStringToDate("2019-08-31",
	 * "yyyy-MM-dd")); }
	 */
	
	public static  ApiErrorResponseEntity buildApiErrorResponseEntity(List<String> errors,HttpStatus status) {
		ApiErrorResponseEntity entity = new ApiErrorResponseEntity();
		entity.setRequestDateTime(new Date());
		entity.setDebugMessage("BAD_REQUEST");
		entity.setErrors(errors);
		entity.setMessage("BAD_REQUEST");
		entity.setStatus(status);
		return entity;

	}
	
public static void populateClientConfig(ClientConfig clientConfig  ,ClientConfigDTO clientConfigDTO) {
		
		clientConfig.setId(clientConfigDTO.getId());
		
		clientConfig.setClientName(clientConfigDTO.getClientName());
		clientConfig.setContactNumber(clientConfigDTO.getContactNumber());
		clientConfig.setAlternateNumber(clientConfigDTO.getAlternateNumber());
		clientConfig.setEmail(clientConfigDTO.getEmail());
		
		clientConfig.setRegistrationNumber(clientConfigDTO.getRegistrationNumber());
		clientConfig.setClientType(clientConfigDTO.getClientType());
		
		clientConfig.setAddressLine1(clientConfigDTO.getAddressLine1());
		clientConfig.setAddressLine2(clientConfigDTO.getAddressLine2());
		clientConfig.setPincode(clientConfigDTO.getPincode());
		clientConfig.setStateCode(clientConfigDTO.getStateCode());
		clientConfig.setCoutryCode(clientConfigDTO.getCoutryCode());
		
		//Date Fields 
		//CommonUtils.convertStringToDate(clientConfig.getLiveDateTxt(), "yyyy-MM-dd")
		clientConfig.setOnboardDate(CommonUtils.convertStringToDate(clientConfigDTO.getOnboardDateTxt(), "yyyy-MM-dd"));
		
		if(!StringUtils.isEmpty(clientConfigDTO.getLiveDateTxt())) {
			clientConfig.setLiveDate(CommonUtils.convertStringToDate(clientConfigDTO.getLiveDateTxt(), "yyyy-MM-dd"));
		}
	}





public static void populateClientConfigDTO(ClientConfig clientConfig  ,ClientConfigDTO clientConfigDTO) {
	
	clientConfigDTO.setId(clientConfig.getId());
	clientConfigDTO.setClientName(clientConfig.getClientName());
	clientConfigDTO.setRegistrationNumber(clientConfig.getRegistrationNumber());
	clientConfigDTO.setContactNumber(clientConfig.getContactNumber());
	clientConfigDTO.setAlternateNumber(clientConfig.getAlternateNumber());
	clientConfigDTO.setEmail(clientConfig.getEmail());
	
	clientConfigDTO.setLiveDateTxt(CommonUtils.convertDateToString(clientConfig.getLiveDate(), "yyyy-MM-dd"));
	clientConfigDTO.setOnboardDateTxt(CommonUtils.convertDateToString(clientConfig.getOnboardDate(), "yyyy-MM-dd"));
	clientConfigDTO.setClientCode(clientConfig.getClientCode());
	
	clientConfigDTO.setClientType(clientConfig.getClientType());
	clientConfigDTO.setAddressLine1(clientConfig.getAddressLine1());
	clientConfigDTO.setAddressLine2(clientConfig.getAddressLine2());
	clientConfigDTO.setPincode(clientConfig.getPincode());
	clientConfigDTO.setStateCode(clientConfig.getStateCode());
	clientConfigDTO.setCoutryCode(clientConfig.getCoutryCode());
	
	//Date Fields 
	//CommonUtils.convertStringToDate(clientConfig.getLiveDateTxt(), "yyyy-MM-dd")
	
}



	
	/*
	public static void main ( String args []) {
		String regex  =  "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		String email   =  "test.awasthi@abbc.co.in";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher  = pattern.matcher(email);
		System.out.println("Email : "+matcher.matches());
	}
  */
	
	
}
