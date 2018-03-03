/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.config;

import static com.desafio.api.jwt.service.TokenAuthenticationService.EXPIRATIONTIME;
import static com.desafio.api.jwt.service.TokenAuthenticationService.HEADER_STRING;
import static com.desafio.api.jwt.service.TokenAuthenticationService.SECRET;
import static com.desafio.api.jwt.service.TokenAuthenticationService.TOKEN_PREFIX;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author deoprog
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.desafio.api.controller"))
                .paths(PathSelectors.any()).build()                
                .apiInfo(apiIno());
    }

    private ApiInfo apiIno() {
        return new ApiInfoBuilder().title("Desafio mais vida")
                .description("Documentação de acesso a API Desafio mais vida")
                .contact(new Contact("Jardel Marden", "https://github.com/deoprog/desafio-mais-vida", "deoprog@gmail.com"))
                .version("1.0.0")
                .build();
    }

    @Bean
    public SecurityConfiguration security() {
        String JWT;
        try {
            JWT = Jwts.builder()
                    .setSubject("admin")
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                    .signWith(SignatureAlgorithm.HS512, SECRET)
                    .compact();
            System.err.println(JWT);
        } catch (Exception e) {
            JWT = "";
        }

        return new SecurityConfiguration(null, null, null, null, TOKEN_PREFIX + " " + JWT, ApiKeyVehicle.HEADER,
                HEADER_STRING, ",");
    }
}
