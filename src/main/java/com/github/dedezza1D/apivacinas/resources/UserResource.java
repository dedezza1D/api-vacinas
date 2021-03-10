package com.github.dedezza1D.apivacinas.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.dedezza1D.apivacinas.domain.User;
import com.github.dedezza1D.apivacinas.services.UserService;

@Controller //para falar que a classe é um recurso web que é implementado por um controlador rest
@RequestMapping (value = "/user") // para dar o nome ao recurso
public class UserResource {
	
	@Autowired
	private UserService service;
	
  @PostMapping
  public ResponseEntity<User> insert(@RequestBody User obj) throws Exception{
	  try {
		obj = service.insert(obj);
		  URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).body(obj);
	} catch (Exception e) {
		throw new Exception("Não foi possível inserir novo usuário!");
	}

  }
	
}
