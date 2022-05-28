package com.java.springboot.Pfa.ProjetPfa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.Pfa.ProjetPfa.Repository.AppartementRepository;
import com.java.springboot.Pfa.ProjetPfa.Repository.ImmeubleRepository;
import com.java.springboot.Pfa.ProjetPfa.model.Appartement;
import com.java.springboot.Pfa.ProjetPfa.model.Immeuble;




@Service
public class AppartementService {
	@Autowired
	AppartementRepository appartementRepository;

	public Appartement saveT(Appartement o) {
		return appartementRepository.save(o);
	}

	public Appartement updateT(Appartement o , int id) {
		Appartement appartementToEdit = appartementRepository.findById(id).get();
		appartementToEdit.setNumero(o.getNumero());
		appartementToEdit.setEtage(o.getEtage());
		appartementToEdit.setSurface(o.getSurface());
		appartementToEdit.setImmeuble(o.getImmeuble());
		return appartementRepository.save(appartementToEdit);

	}

	public void detele(Appartement o) {
		appartementRepository.delete(o);
		
	}


	public void deletebyId(int id) {
		appartementRepository.deleteById(id);
	}

	public Appartement getbyId(int id) {
		return appartementRepository.findById(id).get();
	}

	public List<Appartement> getAll() {
		return appartementRepository.findAll();
	}

	
}
