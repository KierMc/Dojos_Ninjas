package com.kiernan.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kiernan.dojosninjas.models.Dojo;
import com.kiernan.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {

	private final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public List<Dojo> findAll() {
		return dojoRepo.findAll();
	}
	
	public Dojo create (Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Dojo getDojo(Long id) {
		Optional<Dojo> potentialDojo = dojoRepo.findById(id);
		return potentialDojo.isPresent() ? potentialDojo.get() : null;
	}

}
