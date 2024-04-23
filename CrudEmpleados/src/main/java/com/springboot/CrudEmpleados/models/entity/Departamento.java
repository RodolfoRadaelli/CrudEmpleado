package com.springboot.CrudEmpleados.models.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Departamentos")
public class Departamento implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String departamentoNombre;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartamentoNombre() {
		return departamentoNombre;
	}
	public void setDepartamentoNombre(String departamentoNombre) {
		this.departamentoNombre = departamentoNombre;
	}
	
	@Override
	public String toString() {
		return "Departamento [id=" + id + ", departamentoNombre=" + departamentoNombre + "]";
	}
    
}