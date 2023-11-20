package com.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableCaching
public class CalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}


	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.calculator"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	    		 .title("Calculator Api")
	                .description("Calculator Services Documentation for API developers")
	                .termsOfServiceUrl("http://localhost:8080/")
	                .license("Calculator")
	                .licenseUrl("http://Calculator/LICENSE")
	                .version("1.0")
	                .build();	
	}
}
