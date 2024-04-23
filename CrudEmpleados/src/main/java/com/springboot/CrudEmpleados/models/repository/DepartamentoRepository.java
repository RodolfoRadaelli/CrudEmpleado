package com.springboot.CrudEmpleados.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.CrudEmpleados.models.entity.Departamento;

@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento, Long> {
	
}
