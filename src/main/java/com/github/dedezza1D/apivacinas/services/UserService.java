package com.github.dedezza1D.apivacinas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dedezza1D.apivacinas.domain.User;
import com.github.dedezza1D.apivacinas.repositories.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User insert(User obj) throws Exception {
		try {

			Optional<User> userOptional1 = repository.findByEmail(obj.getEmail());
			Optional<User> userOptional2 = repository.findByCpf(obj.getCpf());
			if (userOptional1.isPresent())
				throw new Exception("Email já cadastrado");
			
			if (userOptional2.isPresent())
				throw new Exception("CPF já cadastrado");
			
			return repository.save(obj);
				
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro inesperado");
		}

	}
}
