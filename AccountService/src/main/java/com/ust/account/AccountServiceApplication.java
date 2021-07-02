package com.ust.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
		
		
	}

	@Bean
	public ApiInfo apiInfo() {
		ApiInfoBuilder infoBuilder = new ApiInfoBuilder();
		
		infoBuilder.title("Accounts Service")
				.version("2.0")
				.license("Liscence To Accounts Services")
				.description("Accounts Service");
		
		return infoBuilder.build();
	}
	
	@Bean
	public Docket apiDocket(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.paths(PathSelectors.any()).build().pathMapping("/").apiInfo(apiInfo())
				.useDefaultResponseMessages(false);
	}
}
