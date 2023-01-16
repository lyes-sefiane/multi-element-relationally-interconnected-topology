package com.cloud.nativ.networkgraph.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-15 1:36 p.m.
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(@Value("${application.title}") String appTitle,
                                 @Value("${application.description}") String appDescription,
                                 @Value("${application.version}") String appVersion) {

        return new OpenAPI()
                .info(new Info()//
                        .title(appTitle)//
                        .description(appDescription)//
                        .version(appVersion)//
                        .license(new License()//
                                .name("MIT")//
                                .url("https://github.com/lyes-s/multi-element-relationally-interconnected-topology/blob/main/LICENSE.md"))
                        .contact(new Contact()//
                                .name("Lyes S.")//
                                .url("https://github.com/lyes-s")//
                                .email("lyes-s@gmail.com")))
                .externalDocs(new ExternalDocumentation()//
                        .description("GitHub Wiki")//
                        .url("https://github.com/lyes-s/multi-element-relationally-interconnected-topology/wiki"));

    }
}
