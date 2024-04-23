package com.springboot.CrudEmpleados.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.CrudEmpleados.models.entity.Departamento;
import com.springboot.CrudEmpleados.models.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImplement implements IDepartamentoService {
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Override
	public List<Departamento> listarTodos() {
		return (List<Departamento>) departamentoRepository.findAll();
	}

}
