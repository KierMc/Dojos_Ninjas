package com.kiernan.dojosninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kiernan.dojosninjas.services.DojoService;

@Controller
public class HomeController {

	
	private final DojoService dojoServ;
	public HomeController(DojoService dojoServ) {
		this.dojoServ = dojoServ;
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allDojos", dojoServ.findAll());
		return "dashboard.jsp";
	}
}
