package com.github.dedezza1D.apivacinas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.dedezza1D.apivacinas.domain.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {


	
}
