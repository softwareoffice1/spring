package com.softwareoffice.proyect.controller;

import com.softwareoffice.proyect.entiry.Enterprise;
import com.softwareoffice.proyect.entiry.MovimientoDinero;
import com.softwareoffice.proyect.service.EmployeeService;
import com.softwareoffice.proyect.service.EnterpriseService;
import com.softwareoffice.proyect.service.MovimientoDineroService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class TransactionController {
        @Autowired
        private MovimientoDineroService movimientoDineroService;
        @Autowired
        EnterpriseService enterpriseService;
        @Autowired
        EmployeeService employeeService;

        @GetMapping(produces = "application/json")
        public List<MovimientoDinero> listaMovimientos() {
            var listaMovimientos = this.movimientoDineroService.getLstMovimientos();
            log.info("Ejecutando desde controlador");
            return listaMovimientos;
        }
        @GetMapping("/transaction/{id_transaction}")
        public MovimientoDinero getMovimientoById(@PathVariable("id_transaction") Long id_transaction) {
            return this.movimientoDineroService.getMovimiento(id_transaction);
        }


        @PostMapping("/saveTransaction")
        public MovimientoDinero crearMovimiento(@ModelAttribute MovimientoDinero movimiento){
            log.info("Ejecutando desde CREAR");
            return this.movimientoDineroService.crearMovimiento(movimiento);
        }
        @DeleteMapping("/transaction/{id_transaction}")
        public void deleteMovimiento(@PathVariable("id_transaction") Long id_transaction) {
            movimientoDineroService.deleteMovimiento(id_transaction);
            log.info("Eliminando registro");
        }

        @PutMapping("/transaction")
        public MovimientoDinero updateMovimiento(@RequestBody MovimientoDinero movimiento) {
            this.movimientoDineroService.updateMovimiento(movimiento);
            return movimiento;
        }

        @PatchMapping("/transaction/{id_transaction}/{conceptInput}/{monto}")
        public MovimientoDinero updateConceptById(@PathVariable("id_transaction") Long id_transaction, @PathVariable("conceptInput") String conceptInput, @PathVariable("monto") float monto) {
            return movimientoDineroService.updatedMovimientoById(id_transaction,conceptInput,monto);
        }

        @RequestMapping("/enterprises")
        public List<Enterprise> OptionEnterprise(Model model) {
            var enterpriseOptions = enterpriseService.findEnterprises();
            return enterpriseOptions;
        }
}
