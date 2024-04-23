package com.springboot.CrudEmpleados.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.CrudEmpleados.models.entity.Trabajador;

@Repository
public interface TrabajadorRepository extends CrudRepository<Trabajador, Long> {

}
