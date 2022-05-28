package com.java.springboot.Pfa.ProjetPfa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.Pfa.ProjetPfa.Repository.PersonneRepository;
import com.java.springboot.Pfa.ProjetPfa.model.Immeuble;
import com.java.springboot.Pfa.ProjetPfa.model.Personne;



@Service
public class PersonneService {
	@Autowired
	PersonneRepository personneRepository;

	public Personne saveT(Personne o) {
		return personneRepository.save(o);
	}

	public Personne updateT(Personne o, int id) {
		Personne personneToEdit = personneRepository.findById(id).get();
		personneToEdit.setNom(o.getNom());
		personneToEdit.setPrenom(o.getPrenom());
		personneToEdit.setEmail(o.getEmail());
		personneToEdit.setPassword(o.getPassword());
		personneToEdit.setTel(o.getTel());
		personneToEdit.setVille(o.getVille());
		return personneRepository.save(personneToEdit);
	}

	public void delete(Personne o) {
		personneRepository.delete(o);

	}

	public void deletebyId(int id) {
		personneRepository.deleteById(id);

	}

	public List<Personne> getAll() {
		return personneRepository.findAll();
	}

	public Personne getbyId(int id) {
		return personneRepository.findById(id).get();
	}

}
