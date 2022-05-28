package com.java.springboot.Pfa.ProjetPfa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.Pfa.ProjetPfa.Repository.RevenusRepository;
import com.java.springboot.Pfa.ProjetPfa.model.Appartement;
import com.java.springboot.Pfa.ProjetPfa.model.Revenus;



@Service
public class RevenuService {
	@Autowired
	RevenusRepository revenusRepository;

	public Revenus saveT(Revenus o) {
		return revenusRepository.save(o);
	}

	public Revenus updateT(Revenus o,int id) {
		Revenus revenuToEdit = revenusRepository.findById(id).get();
		revenuToEdit.setSomme(o.getSomme());
		revenuToEdit.setCommentaire(o.getCommentaire());
		revenuToEdit.setDateRevenu(o.getDateRevenu());
		revenuToEdit.setAppartement(o.getAppartement());
		revenuToEdit.setResidant(o.getResidant());
		revenuToEdit.setImmeuble(o.getImmeuble());
		
		return revenusRepository.save(revenuToEdit);
	}

	public void delete(Revenus o) {
		revenusRepository.delete(o);
	}

	public void deletebyId(int id) {
		revenusRepository.deleteById(id);
	}

	public Revenus getbyId(int id) {
		return revenusRepository.findById(id).get();
	}

	public List<Revenus> getAll() {
		return revenusRepository.findAll();
	}

}
