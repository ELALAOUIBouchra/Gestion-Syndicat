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
import com.java.springboot.Pfa.ProjetPfa.model.Immeuble;
import com.java.springboot.Pfa.ProjetPfa.model.Residant;
import com.java.springboot.Pfa.ProjetPfa.model.Revenus;
import com.java.springboot.Pfa.ProjetPfa.service.AppartementService;
import com.java.springboot.Pfa.ProjetPfa.service.ImmeubleService;
import com.java.springboot.Pfa.ProjetPfa.service.ResidantService;
import com.java.springboot.Pfa.ProjetPfa.service.RevenuService;


@RestController
@RequestMapping("revenus")
public class RevenusController {

	 @Autowired
	 RevenuService revenusService;
	 @Autowired
	 AppartementService appartementService;
	 @Autowired
	 ResidantService residantService;
	 @Autowired
	 ImmeubleService immeubleService;
		
		 public RevenusController(RevenuService revenusService) {
		        this.revenusService = revenusService;
		    }
		 @PostMapping("/save")
		    public void ajouter(@RequestBody Revenus revenus) {
			 
			 Appartement app = appartementService.getbyId(revenus.getAppartement().getIdAppartement());
			 System.out.println("test"+ app.getIdAppartement());
			 revenus.setAppartement(app);
			 
			 Residant res = residantService.getbyId(revenus.getResidant().getIdResidant());
			 System.out.println("test"+ res.getEmail());
			 revenus.setResidant(res);
			 
			 Immeuble imm = immeubleService.getbyId(revenus.getImmeuble().getIdImmeuble());
			 System.out.println("test"+ imm.getNom());
			 revenus.setImmeuble(imm);
			 
			 revenusService.saveT(revenus);
		    }

		    @GetMapping("/all")
		    public List<Revenus> revenus() {
		        return revenusService.getAll();
		    }

		    @PutMapping("edit/{id}")
			public void modifier(@RequestBody Revenus p ,@PathVariable int id) {
		    	revenusService.updateT(p,id);
					
			}
			@DeleteMapping("/{id}")
			public void suppr(@PathVariable Revenus id ) {
				revenusService.delete(id);
					
			}

}

