package com.springboot.CrudEmpleados.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.CrudEmpleados.models.entity.Trabajador;
import com.springboot.CrudEmpleados.models.repository.TrabajadorRepository;

@Service
public class TrabajadorServiceImplement implements ITrabajadorService {
	@Autowired
	private TrabajadorRepository trabajadorRepository;
	
	@Override
	public List<Trabajador> listarTodos() {
		return (List<Trabajador>) trabajadorRepository.findAll();
	}

	@Override
	public void guardar(Trabajador trabajador) {
		trabajadorRepository.save(trabajador);
	}

	@Override
	public Trabajador buscarPorId(Long id) {
		return trabajadorRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		trabajadorRepository.deleteById(id);
	}

}
