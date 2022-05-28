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
import com.java.springboot.Pfa.ProjetPfa.model.Residant;
import com.java.springboot.Pfa.ProjetPfa.model.User;
import com.java.springboot.Pfa.ProjetPfa.service.ResidantService;

@RestController
@RequestMapping("residants")
public class ResidantController {
	@Autowired
	ResidantService residantService;
	@Autowired
	UserRepository userRepository;

	public ResidantController(ResidantService residantService) {
		this.residantService = residantService;
	}

	@PostMapping("/save")
	public void ajouter(@RequestBody Residant residant) {
		User user =new User();
		 user.setUsername(residant.getNom());
		 user.setPassword(residant.getPassword());
		 user.setRole("resident");
		 userRepository.save(user);
		residantService.saveT(residant);
	}

	@GetMapping("/all")
	public List<Residant> residants() {
		return residantService.getAll();
	}

	@PutMapping("edit/{id}")
	public void modifier(@RequestBody Residant p , @PathVariable int id) {
		residantService.updateT(p, id);

	}

	@DeleteMapping("/{id}")
	public void suppr(@PathVariable Residant id) {
		residantService.delete(id);

	}


}
