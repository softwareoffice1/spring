package com.softwareoffice.proyect.repository;

import com.softwareoffice.proyect.entiry.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<MovimientoDinero,Long> {
}
