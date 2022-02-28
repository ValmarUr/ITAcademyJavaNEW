package com.itacademy.crud.h2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Import(SpringDataRestConfiguration.class)
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("employee-api-v1")
				.select()
				//.apis(RequestHandlerSelectors.any())
				//.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.itacademy.crud.h2.controller"))
				.paths(PathSelectors.regex("/api/v1.*"))
				.build()
				.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("S4.02.01 -Simple HTTP Service-")
				.version("1.0")
				.description("API for managing employees")
				.contact(new Contact("Juane Fernández", "https://github.com/ValmarUr/ITAcademyJavaNEW", "monesvol@gmail.com"))
				.build();
	}

}
