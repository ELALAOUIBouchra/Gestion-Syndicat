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

import com.java.springboot.Pfa.ProjetPfa.Repository.CategorieRepository;
import com.java.springboot.Pfa.ProjetPfa.model.Categorie;
import com.java.springboot.Pfa.ProjetPfa.service.CategorieService;


@RestController
@RequestMapping("categories")
public class CategorieController {

	@Autowired
	 CategorieService categorieService;
	@Autowired
	 CategorieRepository categorieRepository;
	
	 public CategorieController(CategorieService categorieService) {
	        this.categorieService = categorieService;
	    }
	 @PostMapping("/save")
	    public void ajouter(@RequestBody Categorie categorie) {
		 categorieService.saveT(categorie);
	    }

	    @GetMapping("/all")
	    public List<Categorie> categories() {
	        return categorieService.getAll();
	    }

	    @PutMapping("edit/{id}")
		public void modifier(@RequestBody Categorie p 
				,@PathVariable int id ) {
	    	categorieService.updateT(p, id);
				
		}
	    @org.springframework.web.bind.annotation.DeleteMapping("/{id}")
		public void suppr(@PathVariable Categorie id ) {
			categorieService.delete(id);
				
		}
	    @GetMapping(value = "/count")
		public long countCategorie() {
			return categorieRepository.count();
		}
	

}
