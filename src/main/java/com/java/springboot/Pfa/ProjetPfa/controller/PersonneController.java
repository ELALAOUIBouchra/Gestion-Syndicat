package com.java.springboot.Pfa.ProjetPfa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.Pfa.ProjetPfa.Repository.UserRepository;
import com.java.springboot.Pfa.ProjetPfa.model.Personne;
import com.java.springboot.Pfa.ProjetPfa.model.User;
import com.java.springboot.Pfa.ProjetPfa.service.PersonneService;



@RestController
@RequestMapping("personnes")
public class PersonneController {
	@Autowired
	PersonneService personneService;
	@Autowired
	UserRepository userRepository;

	public PersonneController(PersonneService personneService) {
		this.personneService = personneService;
	}

	@PostMapping("/save")
	public void ajouter(@RequestBody Personne personne) {
		User user =new User();
		 user.setUsername(personne.getNom());
		 user.setPassword(personne.getPassword());
		 user.setRole("syndic");
		 userRepository.save(user);
		personneService.saveT(personne);
	}

	@GetMapping("/all")
	public List<Personne> personnes() {
		return personneService.getAll();
	}

	@PutMapping("edit/{id}")
	public void modifier(@RequestBody Personne p , @PathVariable int id) {
		personneService.updateT(p, id);

	}

	@DeleteMapping("/{id}")
	public void suppr(@PathVariable Personne id) {
		personneService.delete(id);

	}

}
