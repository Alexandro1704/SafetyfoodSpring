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

import pe.edu.upc.demo.entities.Distrito;
import pe.edu.upc.demo.serviceinterface.IDistritoService;

@Controller
@RequestMapping("/distritoss")
public class DistritoController {
	@Autowired
	private IDistritoService disService;

	@GetMapping("/nuevo")
	public String newDistrito(Model model) {
		model.addAttribute("dt", new Distrito());
		return "distrito/frmRegisterdistrito";
	}

	@PostMapping("/guardar")
	public String saveDistrito(@Valid Distrito di, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			model.addAttribute("error", "Ocurrió un error!!");
			return "distrito/frmRegisterdistrito";
		} else {
			disService.insert(di);
			model.addAttribute("mensaje", "Se guardó correctamente!!");
			return "redirect:/distritoss/nuevo";
		}
	}

	@GetMapping("/listar")
	public String listDistrito(Model model) {
		try {
			model.addAttribute("listaDistritos", disService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/distrito/frmListdistrito";
	}
	@RequestMapping("/eliminar")
	public String deleteDistrito(Map<String, Object> model, @RequestParam(value ="id") Integer id) {
		try {
			if (id!=null && id>0) {
				disService.delete(id);
				model.put("listaDistritos", disService.list());
			}
		} catch(Exception e) {
			model.put("error", e.getMessage());
		}
		return "distrito/frmListdistrito";
		
	}
	
	@RequestMapping("irmodificar/{id}")
	public String goUpdateDistrito(@PathVariable int id, Model model) {
		Optional<Distrito> objDis = disService.listId(id);
		model.addAttribute("dtt", objDis.get());
		return "distrito/frmUpdatedistrito";	
	}
	
	@PostMapping("/modificar")
	public String updateDistrito(Distrito di) {
		disService.update(di);
		return "redirect:/distritoss/listar";	
	}
}