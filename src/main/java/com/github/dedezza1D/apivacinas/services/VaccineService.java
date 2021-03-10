package com.github.dedezza1D.apivacinas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dedezza1D.apivacinas.domain.Vaccine;
import com.github.dedezza1D.apivacinas.repositories.VaccineRepository;

@Service
public class VaccineService {

	
	@Autowired
	private VaccineRepository repository;
	
	public Vaccine insert(Vaccine obj) {
		return repository.save(obj);
	}
}
