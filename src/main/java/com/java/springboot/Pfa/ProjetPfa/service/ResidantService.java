package com.java.springboot.Pfa.ProjetPfa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.java.springboot.Pfa.ProjetPfa.Repository.ResidantRepository;

import com.java.springboot.Pfa.ProjetPfa.model.Residant;

@Service
public class ResidantService {
	@Autowired
	ResidantRepository residantRepository;

	public Residant saveT(Residant o) {
		return residantRepository.save(o);
	}

	public Residant updateT(Residant o, int id) {
		Residant personneToEdit = residantRepository.findById(id).get();
		personneToEdit.setNom(o.getNom());
		personneToEdit.setPrenom(o.getPrenom());
		personneToEdit.setEmail(o.getEmail());
		personneToEdit.setPassword(o.getPassword());
		personneToEdit.setTel(o.getTel());
		personneToEdit.setVille(o.getVille());
		return residantRepository.save(personneToEdit);
	}

	public void delete(Residant o) {
		residantRepository.delete(o);

	}

	public void deletebyId(int id) {
		residantRepository.deleteById(id);

	}

	public List<Residant> getAll() {
		return residantRepository.findAll();
	}

	public Residant getbyId(int id) {
		return residantRepository.findById(id).get();
	}


}
