package com.github.dedezza1D.apivacinas.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.dedezza1D.apivacinas.domain.User;
import com.github.dedezza1D.apivacinas.domain.Vaccine;
import com.github.dedezza1D.apivacinas.services.VaccineService;

@Controller //para falar que a classe é um recurso web que é implementado por um controlador rest
@RequestMapping (value = "/vaccine") // para dar o nome ao recurso
public class VaccineResource {
	
	@Autowired
	private VaccineService service;
	
  @PostMapping
  public ResponseEntity<Vaccine> insert(@RequestBody Vaccine obj){
	  obj = service.insert(obj);
	  URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
  }
	
}
