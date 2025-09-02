package com.itsqmet.proyecto_bd2.repository;

import com.itsqmet.proyecto_bd2.entity.Empleado;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends MongoRepository<Empleado, String> {
}
