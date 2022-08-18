package com.example.oauth.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/beveiligd") //Deze controller verwerkt alle gets naar /beveiligd
public class BeveiligdeController {
    @GetMapping
    public ModelAndView securedPage(@AuthenticationPrincipal OAuth2User user){
        //Bij een request naar de URL moet de gebruiker eerst inloggen op GitHub. Pas als dat lukt komt de request in deze method binnen.
        //Je geeft de method de param @AuthenticationPrincipal -> Spring vult de parameter met eigenschappen over de ingelogde gebruiker.
        return new ModelAndView("beveiligd", "gebruikersNaam", user.getAttribute("login"));
        //Je vraagt de eigenschap login. Dit is de gebruikersnaam van de gebruiker op GitHub. Je geeft die gebruikersnaam door aan TL pagina.
    }
}
