package org.springframework.samples.petclinic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * 
 * 
 * Jan 16, 2020
 *
 * @author Tharunkumar Bairoju
 *
 */
@Configuration
public class SpringFoxConfig {

	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("PET-CLINIC API").description("Pet-clinic sample application for testing")
						.version("v0.0.1").license(new License().name("Apache 2.0").url("http://springdoc.org")))
				.externalDocs(new ExternalDocumentation().description("Pet-clinic Wiki Documentation")
						.url("https://springshop.wiki.github.org/docs"));
	}
}