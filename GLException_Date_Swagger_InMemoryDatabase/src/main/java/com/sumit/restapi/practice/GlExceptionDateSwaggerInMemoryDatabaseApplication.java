package com.sumit.restapi.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories
@EnableSwagger2
public class GlExceptionDateSwaggerInMemoryDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlExceptionDateSwaggerInMemoryDatabaseApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfig()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.sumit.restapi.practice"))
				.build()
				.apiInfo(apiDetails());
				
	}	
	
	public ApiInfo apiDetails()
	{
		return new ApiInfoBuilder()
				.title("ITEM API")
				.version("1.0")
				.contact(new Contact("SUMIT KUMAR MANDAL", "https://www.amazon.com","sumit06420@gmail.com"))
				.license("API License")
				.build();
	}
	
}
