package com.kiernan.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kiernan.dojosninjas.models.Ninja;
import com.kiernan.dojosninjas.services.DojoService;
import com.kiernan.dojosninjas.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	
	private final NinjaService ninjaServ;
	private final DojoService dojoServ;

	public NinjaController(NinjaService ninjaServ, DojoService dojoServ) {
		this.ninjaServ = ninjaServ;
		this.dojoServ = dojoServ;
	}
	
	@GetMapping("/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("allDojos", dojoServ.findAll());
		return "ninja/create.jsp";
	}
	
	@PostMapping("/new")
	public String processNewNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allDojos", dojoServ.findAll());
			return "ninja/create.jsp";
		}
		ninjaServ.create(ninja);
		return "redirect:/";
		
	}

}
