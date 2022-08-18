package com.example.oauth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain geefRechten(HttpSecurity http) throws Exception{
        http.oauth2Login(); //Definieer dat je OAuth gebruikt. De gebruiker zal dus inloggen op een andere website.
        http.authorizeRequests(requests -> requests
                .mvcMatchers("/").permitAll() //Iedereen heeft toegang tot de beginpagina
                .mvcMatchers("/beveiligd").authenticated()); //Enkel ingelogde users hebben toegang tot de URL beveiligd, als ze deze pagina opnenen
                                                                      //moeten ze eerst inloggen op GitHub.
        return http.build();
    }
}
