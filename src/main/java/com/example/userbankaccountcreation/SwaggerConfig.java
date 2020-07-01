package com.example.userbankaccountcreation;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(Predicates.not(PathSelectors.regex("/error.*"))).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return new ApiInfo("UserBankAccountCreation", "User Bank Account Creation for Users RESTful api documentation", "1", "terms",
				new Contact("team", "www.UserBankAccountCreation.com", "support@library.com"), "license number", "lecence url",
=======
		return new ApiInfo("Bankingproj", "Bank Account Creation for user RESTful api documentation", "1", "terms",
				new Contact("Sparks", "www.Bankingproj.com", "support@library.com"), "license number", "lecence url",
>>>>>>> d53368d25741fe664e6e8859106ab0f5c28a1daf
				Collections.emptyList());
	}
}
