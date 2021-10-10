package com.init.vocl.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lexicoOCL.analizadorSintactico;

@RestController 
@RequestMapping("analizarocl")
public class voclREST {
	
	//@GetMapping
	@RequestMapping(value="{value}")
	public String getAnalisisOCL(@PathVariable("value") String variable) {
		String analizar = variable.replaceAll("!", "\n");
		return analizadorSintactico.analizadorSintactico(analizar);
	}
	

}
