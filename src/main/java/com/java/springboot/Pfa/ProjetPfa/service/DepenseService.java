package com.java.springboot.Pfa.ProjetPfa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.Pfa.ProjetPfa.Repository.DepenseRepository;
import com.java.springboot.Pfa.ProjetPfa.model.Depense;

@Service
public class DepenseService {
	@Autowired
	DepenseRepository depenseRepository;

	public Depense saveT(Depense o) {
		return depenseRepository.save(o);
	}

	public Depense updateT(Depense o , int id) {
		Depense depenseToEdit = depenseRepository.findById(id).get();
		depenseToEdit.setDescription(o.getDescription());
		depenseToEdit.setMontant(o.getMontant());
		depenseToEdit.setDateDepense(o.getDateDepense());
		depenseToEdit.setImmeuble(o.getImmeuble());
		depenseToEdit.setCategorie(o.getCategorie());
		return depenseRepository.save(depenseToEdit);

	}

	public void delete(Depense o) {
		depenseRepository.delete(o);
		
	}


	public void deletebyId(int id) {
		depenseRepository.deleteById(id);
	}

	public Depense getbyId(int id) {
		return depenseRepository.findById(id).get();
	}

	public List<Depense> getAll() {
		return depenseRepository.findAll();
	}

	

}
