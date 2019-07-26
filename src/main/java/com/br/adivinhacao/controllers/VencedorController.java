package com.br.adivinhacao.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.adivinhacao.model.VencedorModel;
import com.br.adivinhacao.services.VencedorService;

@Controller
public class VencedorController {
	@Autowired
	private VencedorService vencedorService;

	@GetMapping("/")
	public ModelAndView exibirVencedores() {
		ModelAndView modelAndView = new ModelAndView("home.html");
		modelAndView.addObject(vencedorService);
		return modelAndView;
	}

	@PostMapping("/")
	public ModelAndView mostrarJogo(@Valid VencedorModel vencedor, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("home.html");

		if (bindingResult.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			for (ObjectError objectError : bindingResult.getAllErrors()) {
				erros.add(objectError.getDefaultMessage());
			}
			modelAndView.addObject("erros", erros);
		} else {
			modelAndView.addObject("erros", vencedorService.salvarVencedores(vencedor));
			
		}return modelAndView;
}
}
