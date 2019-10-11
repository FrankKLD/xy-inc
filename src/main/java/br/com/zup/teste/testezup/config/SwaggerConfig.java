package br.com.zup.teste.testezup.config;

import com.fasterxml.classmate.TypeResolver;
import com.sun.corba.se.spi.ior.ObjectId;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
@EnableAutoConfiguration
public class SwaggerConfig {
    TypeResolver typeResolver = new TypeResolver();

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .alternateTypeRules(new AlternateTypeRule(typeResolver.resolve(ObjectId.class),typeResolver.resolve(String.class)))
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.zup.teste.testezup.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot REST API with Swagger - Produtcs API REST")
                .description("API REST for produts")
                .contact("frank.de.novo@gmail.com")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licensen.html")
                .version("1.0")
                .build();
    }
}
