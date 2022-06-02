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

import pe.edu.upc.demo.entities.Tipocertificado;
import pe.edu.upc.demo.serviceinterface.ITipocertificadoService;

@Controller
@RequestMapping("/tipocertificadoss")
public class TipocertificadoController {
	@Autowired
	private ITipocertificadoService tipService;

	@GetMapping("/nuevo")
	public String newTipocertificado(Model model) {
		model.addAttribute("tt", new Tipocertificado());
		return "tipocertificado/frmRegistertipocertificado";
	}

	@PostMapping("/guardar")
	public String saveTipocertificado(@Valid Tipocertificado tc, BindingResult binRes, Model model) {
			tipService.insert(tc);
			model.addAttribute("mensaje", "Se guardó correctamente!!");
			return "redirect:/tipocertificadoss/nuevo";
		}
	@GetMapping("/listar")
	public String listTipocertificado(Model model) {
		try {
			model.addAttribute("listaTipocertificados", tipService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/tipocertificado/frmListtipocertificado";
	}
	@RequestMapping("/eliminar")
	public String deleteTipocertificado(Map<String, Object> model, @RequestParam(value ="id") Integer id) {
		try {
			if (id!=null && id>0) {
				tipService.delete(id);
				model.put("listaTipocertificados", tipService.list());
			}
		} catch(Exception e) {
			model.put("error", e.getMessage());
		}
		return "tipocertificado/frmListtipocertificado";
		
	}
	
	@RequestMapping("irmodificar/{id}")
	public String goUpdateTipocertificado(@PathVariable int id, Model model) {
		Optional<Tipocertificado> objTip = tipService.listId(id);
		model.addAttribute("ttd", objTip.get());
		return "tipocertificado/frmUpdatetipocertificado";	
	}
	
	@PostMapping("/modificar")
	public String updateTipocertificado(Tipocertificado tc) {
		tipService.update(tc);
		return "redirect:/tipocertificadoss/listar";	
	}
}