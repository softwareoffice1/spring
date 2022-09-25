package com.softwareoffice.proyect.repository;

import com.softwareoffice.proyect.entiry.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
