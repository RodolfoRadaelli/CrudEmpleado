package com.springboot.CrudEmpleados.models.service;

import java.util.List;

import com.springboot.CrudEmpleados.models.entity.Trabajador;

public interface ITrabajadorService {
	public List<Trabajador> listarTodos();
	public void guardar (Trabajador trabajador);
	public Trabajador buscarPorId(Long id);
	public void eliminar (Long id);
}
