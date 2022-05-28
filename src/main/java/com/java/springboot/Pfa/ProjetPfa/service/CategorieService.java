package com.java.springboot.Pfa.ProjetPfa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.Pfa.ProjetPfa.Repository.CategorieRepository;
import com.java.springboot.Pfa.ProjetPfa.model.Categorie;
import com.java.springboot.Pfa.ProjetPfa.model.Immeuble;



@Service
public class CategorieService {
	@Autowired
	CategorieRepository categorieRepository;

	public Categorie saveT(Categorie o) {
		return categorieRepository.save(o);
	}

	public Categorie updateT(Categorie o, int id) {
		Categorie categorieToEdit = categorieRepository.findById(id).get();
		categorieToEdit.setDescription(o.getDescription());
		
		return categorieRepository.save(categorieToEdit);
	}

	public void delete(Categorie o) {
		categorieRepository.delete(o);
	}

	public void deletebyId(int id) {
		categorieRepository.deleteById(id);
	}

	public Categorie getbyId(int id) {
		return categorieRepository.findById(id).get();
	}

	public List<Categorie> getAll() {
		return categorieRepository.findAll();
	}

}
