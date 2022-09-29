package com.softwareoffice.proyect.controller;

import com.softwareoffice.proyect.entiry.Employee;
import com.softwareoffice.proyect.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/user")
    public List<Employee> crearEmpleado (@RequestBody Employee employee){
        employeeService.crearEmpleado (employee);
        return employeeService.consultarEmpleados ();
    }

    @GetMapping("/user")
    public List<Employee> consultarEmpleados (){
        List<Employee> employee = employeeService.consultarEmpleados();
        return employee;
    }

    @GetMapping("/user/{id_empleado}")
    public  Employee consultarEmpleado (@PathVariable("id_empleado") Long id_Empleado) {
        return employeeService.consultarEmpleado (id_Empleado) ;
    }

    @DeleteMapping("/user/{id_empleado}")
    private List<Employee> eliminarEmpleado (@PathVariable ("id_empleado") Long id) {
        employeeService.borrarEmpleado(id);
        return employeeService.consultarEmpleados();
    }

    @PatchMapping("/user/{id_empleado}/{nombreEmpleado}")
    public Employee editarNombreEmpleado (@PathVariable ("id_empleado")Long id,@PathVariable ("nombreEmpleado") String nombreEmpleado ){
        employeeService.editarNombreEmpleado(id,nombreEmpleado);
        return employeeService.consultarEmpleado(id);
    }

}
