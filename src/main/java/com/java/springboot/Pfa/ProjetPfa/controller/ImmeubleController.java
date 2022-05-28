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

import com.java.springboot.Pfa.ProjetPfa.model.Immeuble;
import com.java.springboot.Pfa.ProjetPfa.service.ImmeubleService;


@RestController
@RequestMapping("immeubles")
public class ImmeubleController {
	@Autowired
	ImmeubleService immeubleService;

	public ImmeubleController(ImmeubleService immeubleService) {
		this.immeubleService = immeubleService;
	}

	@PostMapping("/save")
	public void ajouter(@RequestBody Immeuble immeuble) {
		immeubleService.saveT(immeuble);
	}

	@GetMapping("/all")
	public List<Immeuble> immeubles() {
		return immeubleService.getAll();
	}

	@PutMapping("edit/{id}")
	public void modifier(@RequestBody Immeuble p
			,@PathVariable int id) {
		immeubleService.updateT(p, id);

	}

	@DeleteMapping("/{id}")
	public void suppr(@PathVariable Immeuble id) {
		immeubleService.delete(id);

	}

}


