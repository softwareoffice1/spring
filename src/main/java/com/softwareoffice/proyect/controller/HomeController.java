package com.softwareoffice.proyect.controller;

import com.softwareoffice.proyect.service.MovimientoDineroService;
import lombok.extern.slf4j.Slf4j;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@Controller
@Slf4j
@RestController
@RequestMapping("/software")
public class HomeController {
    @Autowired
    private MovimientoDineroService movimientoDineroService;

    @GetMapping("/")
    public String verHome(Model model, @AuthenticationPrincipal OidcUser principal) {
        String titulo = "home";
        log.info("saludos desde Home");
        model.addAttribute("titulo", titulo);
        return "home";
    }

    @GetMapping("/empresas")
    public String verEnterprise(Model model) {
        String title = "Empresas";
        model.addAttribute("title",title);
        return "enterprise";
    }

    @GetMapping("/movements")
    public String verMovements(Model model) {
        var movimientos = movimientoDineroService.getLstMovimientos();
        model.addAttribute("movimientos", movimientos);
        return "layout/movements";
    }
}



