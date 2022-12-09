package com.kiernan.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kiernan.dojosninjas.models.Dojo;
import com.kiernan.dojosninjas.services.DojoService;

@Controller
@RequestMapping("/dojos")
public class DojoController {

	private final DojoService dojoServ;

	public DojoController(DojoService dojoServ) {
		this.dojoServ = dojoServ;
	}
	
	@GetMapping("/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo/create.jsp";
	}
	
	@PostMapping("/new")
	public String processNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "dojo/create.jsp";
		}
		dojoServ.create(dojo);
		return "redirect:/";
	}
	
	@GetMapping("/view/{id}")
	public String viewDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoServ.getDojo(id));
		return "dojo/view.jsp";
	}

}
