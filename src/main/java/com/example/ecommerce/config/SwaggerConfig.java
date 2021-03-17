/**
 *
 */
package com.example.ecommerce.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Mahender
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private final List<Parameter> listDocketParameters;

	public SwaggerConfig() {
		// Any parameter or header you want to require for all end_points
		Parameter oAuthHeader = new ParameterBuilder().name("Authorization").description("JWT Bearer Token")
				.defaultValue("Bearer ").modelRef(new ModelRef("string")).parameterType("header").required(true)
				.build();

		listDocketParameters = new ArrayList<Parameter>();
		// listDocketParameters.add(oAuthHeader);
	}

	@Bean
	public Docket bridgeAllApi() {
		return new Docket(DocumentationType.SWAGGER_2).globalOperationParameters(listDocketParameters).groupName("all")
				.select().apis(RequestHandlerSelectors.basePackage("com.example.ecommerce"))
				.paths(PathSelectors.ant("/**")).build().forCodeGeneration(true).apiInfo(metaData());
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer swaggerProperties() {
		PropertySourcesPlaceholderConfigurer properties = new PropertySourcesPlaceholderConfigurer();
		return properties;
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("ecommerce").build();
	}

}
