package com.kiernan.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kiernan.dojosninjas.models.Ninja;
import com.kiernan.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	private final NinjaRepository ninjaRepo;
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public Ninja create(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public List<Ninja> findAll() {
		return ninjaRepo.findAll();
	}
	
	public Ninja findOne(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		return optionalNinja.isPresent() ? optionalNinja.get() : null;
	}
	
	public Ninja update(Long id, String firstName, String lastName, Integer age) {
		Ninja ninjaToBeUpdated = ninjaRepo.findById(id).orElse(null);
		ninjaToBeUpdated.setFirstName(firstName);
		ninjaToBeUpdated.setLastName(lastName);
		ninjaToBeUpdated.setAge(age);
		return ninjaRepo.save(ninjaToBeUpdated);
	}
	
	public Ninja update(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public String deleteById(Long id) {
		ninjaRepo.deleteById(id);
		return "You deleted the record with the id of: " + id;
	}

}
