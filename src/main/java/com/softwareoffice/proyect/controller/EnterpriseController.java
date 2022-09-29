package com.softwareoffice.proyect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.softwareoffice.proyect.entiry.Enterprise;
import com.softwareoffice.proyect.service.EnterpriseService;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EnterpriseController {

    @Autowired
    EnterpriseService enterpriseService;

    //Lista todas las empresas
    @GetMapping("/enterprises")
    public List<Enterprise> findEnterprises (){
        List<Enterprise> enterprises = new ArrayList<Enterprise>();
        return enterpriseService.findEnterprises();
    }

    // Crea una empresa
    @PostMapping("/enterprises")
    public RedirectView createEmpresa (@ModelAttribute Enterprise enterprise, Model model){
        model.addAttribute(enterprise);
        this.enterpriseService.createEnterprise(enterprise);
        return new RedirectView("/empresas");
    }

    // Busca la empresa segun id_empresa
    @GetMapping("/enterprises/{id_enterprise}")
    public Enterprise findEnterprise (@PathVariable ("id_enterprise") Long id_enterprise){
        return enterpriseService.findEnterprise(id_enterprise);
    }

    // Actualiza el nit de la Empresa
    @PatchMapping("/enterprises/{id_enterprise}/{document}")
    public Enterprise editDocument (@PathVariable ("id_enterprise") Long id, @PathVariable ("document") String document){
        enterpriseService.editDocument(id, document);
        return enterpriseService.findEnterprise(id);
    }

    @DeleteMapping("/enterprises/{id_enterprise}")
    public List<Enterprise> deleteEnterprise (@PathVariable ("id_enterprise") Long id_enterprise) {
        enterpriseService.deleteEnterprise(id_enterprise);
        return enterpriseService.findEnterprises();
    }

  }