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

import pe.edu.upc.demo.entities.Plato;
import pe.edu.upc.demo.serviceinterface.IPlatoService;

@Controller
@RequestMapping("/platos")
public class PlatoController {
	@Autowired
	private IPlatoService plaService;

	@GetMapping("/nuevo")
	public String newPlato(Model model) {
		model.addAttribute("pt", new Plato());
		return "Plato/frmRegisterplato";
	}

	@PostMapping("/guardar")
	public String savePlato(@Valid Plato pl, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			model.addAttribute("error", "Ocurrió un error!!");
			return "plato/frmRegisterplato";
		} else {
			plaService.insert(pl);
			model.addAttribute("mensaje", "Se guardó correctamente!!");
			return "redirect:/platos/nuevo";
		}
	}

	@GetMapping("/listar")
	public String listPlato(Model model) {
		try {
			model.addAttribute("listaPlatos", plaService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/plato/frmListplato";
	}
	@RequestMapping("/eliminar")
	public String deletePlato(Map<String, Object> model, @RequestParam(value ="id") Integer id) {
		try {
			if (id!=null && id>0) {
				plaService.delete(id);
				model.put("listaPlatos", plaService.list());
			}
		} catch(Exception e) {
			model.put("error", e.getMessage());
		}
		return "plato/frmListplato";
		
	}
	
	@RequestMapping("irmodificar/{id}")
	public String goUpdatePlato(@PathVariable int id, Model model) {
		Optional<Plato> objPla = plaService.listId(id);
		model.addAttribute("pto", objPla.get());
		return "plato/frmUpdateplato";	
	}
	
	@PostMapping("/modificar")
	public String updatePlato(Plato pl) {
		plaService.update(pl);
		return "redirect:/platos/listar";	
	}
}