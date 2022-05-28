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

import com.java.springboot.Pfa.ProjetPfa.Repository.SyndicRepository;
import com.java.springboot.Pfa.ProjetPfa.Repository.UserRepository;
import com.java.springboot.Pfa.ProjetPfa.model.Syndic;
import com.java.springboot.Pfa.ProjetPfa.model.User;
import com.java.springboot.Pfa.ProjetPfa.service.SyndicService;




@RestController
@RequestMapping("syndics")
public class SyndicController {
	 @Autowired
	 SyndicService syndicService;
	 
		
		 public SyndicController(SyndicService syndicService) {
		        this.syndicService = syndicService;
		    }
		 @PostMapping("/save")
		    public void ajouter(@RequestBody Syndic syndic) {
			 
			 syndicService.saveT(syndic);
		    }

		    @GetMapping("/all")
		    public List<Syndic> syndics() {
		        return syndicService.getAll();
		    }

		    @PutMapping("/{id}")
			public void modifier(@RequestBody Syndic p ) {
		    	syndicService.updateT(p);
					
			}
			@DeleteMapping("/syndics/{id}")
			public void suppr(@PathVariable Syndic id ) {
				syndicService.delete(id);
					
			}


}

