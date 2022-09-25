package com.softwareoffice.proyect.service;


import com.softwareoffice.proyect.entiry.Enterprise;

import com.softwareoffice.proyect.repository.EnterpriseRepository;
import com.softwareoffice.proyect.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class EnterpriseService {

    @Autowired
    EnterpriseRepository enterpriseRepository;
    @Autowired
    TransactionRepository repository;

    // Metodo consulta una empresa en especifico
    public Enterprise findEnterprise(Long id_enterprise) {
        return this.enterpriseRepository.findById(id_enterprise).get();
    }

    // Metodo crea registro de empresas
    public void createEnterprise(Enterprise enterprise) {
        enterpriseRepository.save(enterprise);
    }

    // Metodo consulta todas las empresas
    public List<Enterprise> findEnterprises() {
        return new ArrayList<Enterprise>(enterpriseRepository.findAll());
    }

    // Metodo actualiza nit empresa
    public Enterprise editDocument(Long id, String document) {
        Enterprise enterprise = enterpriseRepository.findById(id).get();
        enterprise.setDocument(document);
        return enterpriseRepository.save(enterprise);
    }

    // Metodo elimina empresa
    public void deleteEnterprise (Long id_enterprise){
        enterpriseRepository.deleteById(id_enterprise);
    }

}