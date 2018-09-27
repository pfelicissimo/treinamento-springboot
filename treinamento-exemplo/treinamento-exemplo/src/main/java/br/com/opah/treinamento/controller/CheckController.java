package br.com.opah.treinamento.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/check")
public class CheckController {

	
	@GetMapping(path ="")
	public String check() {
		
		return "OK";
	}
	
}
