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

import com.java.springboot.Pfa.ProjetPfa.model.Appartement;
import com.java.springboot.Pfa.ProjetPfa.model.Categorie;
import com.java.springboot.Pfa.ProjetPfa.model.Depense;
import com.java.springboot.Pfa.ProjetPfa.model.Immeuble;
import com.java.springboot.Pfa.ProjetPfa.service.AppartementService;
import com.java.springboot.Pfa.ProjetPfa.service.CategorieService;
import com.java.springboot.Pfa.ProjetPfa.service.DepenseService;
import com.java.springboot.Pfa.ProjetPfa.service.ImmeubleService;

@RestController
@RequestMapping("depenses")
public class DepenseController {
	
	 @Autowired
	 DepenseService depenseService;
	 @Autowired
	 ImmeubleService immeubleService;
	 @Autowired
	 CategorieService categorieService;
	 
	 public DepenseController (DepenseService  depenseService ) {
	        this.depenseService =depenseService;
	    }
	 @PostMapping("/save")
	    public void ajouter(@RequestBody Depense depense) {
		 
		 Immeuble imm = immeubleService.getbyId(depense.getImmeuble().getIdImmeuble());
		 System.out.println("test"+ imm.getNom());
		 depense.setImmeuble(imm);
		 
		 Categorie cat = categorieService.getbyId(depense.getCategorie().getIdCategorie());
		 depense.setCategorie(cat);
		 
		 
		 depenseService.saveT(depense);
	    }

	    @GetMapping("/all")
	    public List<Depense> revenus() {
	        return depenseService.getAll();
	    }

	    @PutMapping("edit/{id}")
		public void modifier(@RequestBody Depense  p ,@PathVariable int id) {
	    	depenseService.updateT(p,id);
				
		}
		@DeleteMapping("/{id}")
		public void suppr(@PathVariable Depense id ) {
			depenseService.delete(id);
				
		}


}
