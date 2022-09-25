package com.softwareoffice.proyect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnterpriseController {

    @Autowired
    EmployeeService employeeService;

    // El sistema devuelve responses 200 en la ruta /enterprises con los siguientes verbos: |GET|POST|

    // Consulta todas las empresas
    @GetMapping("/enterprises")
    public List<Enterprise> findEnterprises (){
        List<Enterprise> enterprises = new ArrayList<Enterprise>();
        return enterpriseService.findEnterprises();
    }

    // Crea una empresa
    @PostMapping("/enterprises")
    public List<Enterprise> createEmpresa (@RequestBody Enterprise enterprise){
        enterpriseService.createEnterprise (enterprise);
        return enterpriseService.findEnterprises();
    }

    // El sistema devuelve responses 200 en la ruta /enterprises/[id] con los siguientes verbos: |GET|PATCH|DELETE|

    // Consulta una empresa en particular segun id_empresa
    @GetMapping("/enterprises/{id_enterprise}")
    public Enterprise findEnterprise (@PathVariable ("id_enterprise") Long id_enterprise){
        return enterpriseService.findEnterprise(id_enterprise);
    }

    // Actualiza nit Empresa
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

    @GetMapping ("/enterprises_movements/{id_enterprise}")
    public List<MovimientoDinero> findMovements (@PathVariable ("id_enterprise") Long id_enterprise) {
        return enterpriseService.findMovements(id_enterprise);
    }


}