package pe.edu.upc.demo.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.demo.entities.Departamento;
import pe.edu.upc.demo.serviceinterface.IDepartamentoService;

@Controller
@RequestMapping("/departamentoss")
public class DepartamentoController {
	@Autowired
	private IDepartamentoService depService;

	@GetMapping("/nuevo")
	public String newDepartamento(Model model) {
		model.addAttribute("dp", new Departamento());
		return "departamento/frmRegisterdepartamento";
	}

	@PostMapping("/guardar")
	public String saveDepartamento(@Valid Departamento de, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			model.addAttribute("error", "Ocurrió un error!!");
			return "departamento/frmRegisterdepartamento";
		} else {
			depService.insert(de);
			model.addAttribute("mensaje", "Se guardó correctamente!!");
			return "redirect:/departamentoss/nuevo";
		}
	}

	@GetMapping("/listar")
	public String listDepartamento(Model model) {
		try {
			model.addAttribute("listaDepartamentos", depService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/departamento/frmListdepartamento";
	}
	@RequestMapping("/eliminar")
	public String deleteDepartamento(Map<String, Object> model, @RequestParam(value ="id") Integer id) {
		try {
			if (id!=null && id>0) {
				depService.delete(id);
				model.put("listaDepartamentos", depService.list());
			}
		} catch(Exception e) {
			model.put("error", e.getMessage());
		}
		return "departamento/frmListdepartamento";
		
	}
	
	@RequestMapping("irmodificar/{id}")
	public String goUpdateDepartamento(@PathVariable int id, Model model) {
		Optional<Departamento> objDep = depService.listId(id);
		model.addAttribute("dpt", objDep.get());
		return "departamento/frmUpdatedepartamento";	
	}
	
	@PostMapping("/modificar")
	public String updateDepartamento(Departamento de) {
		depService.update(de);
		return "redirect:/departamentoss/listar";	
	}
}