package com.springboot.CrudEmpleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.springboot.CrudEmpleados.models.entity.Departamento;
import com.springboot.CrudEmpleados.models.entity.Trabajador;
import com.springboot.CrudEmpleados.models.service.IDepartamentoService;
import com.springboot.CrudEmpleados.models.service.ITrabajadorService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/views/empleados")
public class EmpleadosController {
	@Autowired
	private ITrabajadorService trabajadorService; 
	
	@Autowired
	private IDepartamentoService departamentoService;

	@GetMapping("/")
	public String mostrarTabla(Model model)
	{
		List<Trabajador> listaTrabajador = trabajadorService.listarTodos(); 
		
		model.addAttribute("titulo", "Tabla de Empleados");
		model.addAttribute("listaTrabajadores", listaTrabajador);
		
		return "/views/empleados/tabla";
	}
	
	@GetMapping("/new")
	public String mostrarFormulario(Model model)
	{
		Trabajador trabajador = new Trabajador();
		List<Departamento> listaDepartamentos = departamentoService.listarTodos();
		
		model.addAttribute("titulo", "Nuevo empleado");
		model.addAttribute("empleadoNuevo", trabajador);
		model.addAttribute("departamentosListado", listaDepartamentos);
		return "/views/empleados/formulario";
	}
	
	@PostMapping("/save")
	public String guardarFormulario(@Valid @ModelAttribute("empleadoNuevo") Trabajador nuevo, BindingResult result, Model model)
	{
		List<Departamento> listaDepartamentos = departamentoService.listarTodos();
		
		if(result.hasErrors())
		{
			model.addAttribute("titulo", "Nuevo empleado");
			model.addAttribute("empleadoNuevo", nuevo);
			model.addAttribute("departamentosListado", listaDepartamentos);
			return "/views/empleados/formulario";
		}
		
		trabajadorService.guardar(nuevo);
		
		return "redirect:/views/empleados/";
	}
	
	@GetMapping("/edit/{indice}")
	public String editarMiembro(@PathVariable("indice") Long id, Model model, RedirectAttributes mensaje)
	{
		Trabajador miembroAGuardar = null;
		
		if (id > 0)
		{
			miembroAGuardar = trabajadorService.buscarPorId(id);
			
			if(miembroAGuardar == null)
			{
				mensaje.addFlashAttribute("error", "No existe empleado con el id ingresado");
				return "redirect:/views/empleados/";
			}
			
		}else
		{
			mensaje.addFlashAttribute("error", "El id es invalido");
			return "redirect:/views/empleados/";
		}
		
		List<Departamento> listaDepartamentos = departamentoService.listarTodos();
		

		model.addAttribute("titulo", "Editar empleado");
		model.addAttribute("empleadoNuevo", miembroAGuardar);
		model.addAttribute("departamentosListado", listaDepartamentos);
		
		return "/views/empleados/formulario";
	}
	
	@GetMapping("/delete/{indice}")
	public String eliminarMiembro(@PathVariable("indice") Long id, Model model, RedirectAttributes mensaje)
	{
		Trabajador miembroAGuardar = null;

		if (id > 0)
		{
			miembroAGuardar = trabajadorService.buscarPorId(id);
			
			if(miembroAGuardar == null)
			{
				mensaje.addFlashAttribute("error", "No existe empleado con el id ingresado");
				return "redirect:/views/empleados/";
			}
			
		}else
		{
			mensaje.addFlashAttribute("error", "El id es invalido");
			return "redirect:/views/empleados/";
		}
		
		trabajadorService.eliminar(id);
		
		return "redirect:/views/empleados/";
	}
}
