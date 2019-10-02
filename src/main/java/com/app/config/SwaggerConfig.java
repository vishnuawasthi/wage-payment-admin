package com.app.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//https://dzone.com/articles/spring-boot-restful-api-documentation-with-swagger
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.app.controller"))
				.paths(regex("/api.*"))
				.build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		//String name, String url, String email
		 Contact contact= new Contact("Vishnu Awasthi", null, "Vishnuawasthi121@gmail.com");
		
		 /**
	  String title,
      String description,
      String version,
      String termsOfServiceUrl,
      Contact contact,
      String license,
      String licenseUrl,
       */
		 ApiInfo apiInfo = new ApiInfo(
				 "Wage Payment Admin",
				 "Api to manage client and employees details in wage payment system",
				 "1.0",
				 "http://localhost:8091/wage-payment-admin",
				 contact,
				 "Open Source",
				 "N/A");
		 return apiInfo;
		 
	 }
}
