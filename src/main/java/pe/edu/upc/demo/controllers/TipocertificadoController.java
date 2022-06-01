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
	private ITipocertificadoService tcdService;
	
	@GetMapping("/nuevo")
	public String newTipocertificado(Model model) {
		model.addAttribute("tt",new Tipocertificado());
		return "tipocertificado/frmRegistertipocertificado";
		
	}
	@PostMapping("/guardar")
	public String saveTipocertificado(@Valid Tipocertificado tc, BindingResult binRes, Model model) {
		if(binRes.hasErrors()) {
			model.addAttribute("error","Ocurrio un error!!");
			return "tipocertificado/frmRegistertipocertificado";
		}
		else {
			tcdService.insert(tc);
			model.addAttribute("mensaje","Se guardo correctamente!!");
			return "redirect:/tipocertificadoss/nuevo";
		}		
	}
	@GetMapping("/listar")
	public String ListTipocertificado(Model model) {
		try {
			model.addAttribute("listaTipocertificados",tcdService.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error",e.getMessage());
		}		
		return "tipocertificado/frmListtipocertificado";
	}
	@RequestMapping("/eliminar")
	public String deleteTipocertificado(Map<String,Object>model,@RequestParam(value="id")Integer id)
	{
		try {
			if (id!=null && id>0) {
				tcdService.delete(id);
				model.put("listaTipocertificados", tcdService.list());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("error", e.getMessage());
		}
		return "tipocertificado/frmListtipocertificado";
	}
	@RequestMapping("irmodificar/{id}")
	public String goUpdateTipocertificado(@PathVariable int id, Model model)
	{
		Optional<Tipocertificado>objTip=tcdService.listId(id);
		model.addAttribute( "ttd",objTip.get());
		return "/person/frmUpdatetipocertificado";
	}
	@PostMapping("modificar")
	public String updateTipocertificado(Tipocertificado tipocertificado)
	{
		tcdService.Update(tipocertificado);
		return "redirect:/tipocertificadoss/listar";		
	}
}
