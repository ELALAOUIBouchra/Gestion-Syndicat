package com.java.springboot.Pfa.ProjetPfa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.Pfa.ProjetPfa.Repository.AppartementRepository;
import com.java.springboot.Pfa.ProjetPfa.Repository.ImmeubleRepository;
import com.java.springboot.Pfa.ProjetPfa.model.Appartement;
import com.java.springboot.Pfa.ProjetPfa.model.Immeuble;
import com.java.springboot.Pfa.ProjetPfa.service.AppartementService;
import com.java.springboot.Pfa.ProjetPfa.service.ImmeubleService;




@RestController
@RequestMapping("appartements")
public class AppartementController {
	@Autowired
	 AppartementService appartementService;
	@Autowired
	ImmeubleService immeubleService;
		
	/* public AppartementController(AppartementService appartementService) {
	        this.appartementService = appartementService;
	    }*/
	 @PostMapping("/save")
	    public void ajouter(@RequestBody Appartement appartement) {
		 Immeuble imm = immeubleService.getbyId(appartement.getImmeuble().getIdImmeuble());
		 System.out.println("test"+ imm.getNom());
		 appartement.setImmeuble(imm);
		 appartementService.saveT(appartement);
	    }
	 

	    @GetMapping("/all")
	    public List<Appartement> appartements() {
	        return appartementService.getAll();
	    }

	    @PutMapping("edit/{id}")
		public void modifier(@RequestBody Appartement p 
				,@PathVariable int id) {
			appartementService.updateT(p, id);
				
		}
		
		
		@org.springframework.web.bind.annotation.DeleteMapping("/{id}")
		public void suppr(@PathVariable Appartement id ) {
			appartementService.detele(id);
				
		}


}
