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

import pe.edu.upc.demo.entities.Tiporestaurante;
import pe.edu.upc.demo.serviceinterface.ITiporestauranteService;

@Controller
@RequestMapping("/tiporestaurantess")
public class TiporestauranteController {
	@Autowired
	private ITiporestauranteService tprService;

	@GetMapping("/nuevo")
	public String newTipocertificado(Model model) {
		model.addAttribute("tr", new Tiporestaurante());
		return "tiporestaurante/frmRegistertiporestaurante";
	}

	@PostMapping("/guardar")
	public String saveTiporestaurante(@Valid Tiporestaurante tp, BindingResult binRes, Model model) {
			tprService.insert(tp);
			model.addAttribute("mensaje", "Se guardó correctamente!!");
			return "redirect:/tiporestaurantess/listar";
		}
	@GetMapping("/listar")
	public String listTiporestaurante(Model model) {
		try {
			model.addAttribute("listaTiporestaurantes", tprService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/tiporestaurante/frmListtiporestaurante";
	}
	@RequestMapping("/eliminar")
	public String deleteTiporestaurante(Map<String, Object> model, @RequestParam(value ="id") Integer id) {
		try {
			if (id!=null && id>0) {
				tprService.delete(id);
				model.put("listaTiporestaurantes", tprService.list());
			}
		} catch(Exception e) {
			model.put("error", e.getMessage());
		}
		return "tiporestaurante/frmListtiporestaurante";
		
	}
	@RequestMapping("irmodificar/{id}")
	public String goUpdateTiporestaurante(@PathVariable int id, Model model) {
		Optional<Tiporestaurante> objTpr = tprService.listId(id);
		model.addAttribute("trr", objTpr.get());
		return "tiporestaurante/frmUpdatetiporestaurante";	
	}
	
	@PostMapping("/modificar")
	public String updateTiporestaurante(Tiporestaurante tp) {
		tprService.update(tp);
		return "redirect:/tiporestaurantess/listar";	
	}
}