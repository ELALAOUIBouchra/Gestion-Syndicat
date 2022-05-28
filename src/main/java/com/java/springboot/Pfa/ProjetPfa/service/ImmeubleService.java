package com.java.springboot.Pfa.ProjetPfa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.Pfa.ProjetPfa.Repository.ImmeubleRepository;
import com.java.springboot.Pfa.ProjetPfa.Repository.SyndicRepository;
import com.java.springboot.Pfa.ProjetPfa.model.Immeuble;
import com.java.springboot.Pfa.ProjetPfa.model.Syndic;


@Service
public class ImmeubleService {
	@Autowired
	ImmeubleRepository immeubleRepository;
	@Autowired
	SyndicRepository syndicRepository;

	public Immeuble saveT(Immeuble o) {
		return immeubleRepository.save(o);
	}

	public Immeuble updateT(Immeuble o, int id) {
		Immeuble immeubleToEdit = immeubleRepository.findById(id).get();
		immeubleToEdit.setAdresse(o.getAdresse());
		immeubleToEdit.setNom(o.getNom());
		immeubleToEdit.setNbrEtage(o.getNbrEtage());
		immeubleToEdit.setNumero(o.getNumero());
		immeubleToEdit.setVille(o.getVille());
		immeubleToEdit.setNbrAppart(o.getNbrAppart());
		return immeubleRepository.save(immeubleToEdit);
	}

	public void delete(Immeuble o) {
		immeubleRepository.delete(o);
	}

	public void deletebyId(int id) {
		immeubleRepository.deleteById(id);
	}

	public Immeuble getbyId(int id) {
		return immeubleRepository.findById(id).get();
	}

	public List<Immeuble> getAll() {
		return immeubleRepository.findAll();
	}

	public Syndic ajouterNewSyndic(Syndic o) {
		return syndicRepository.save(o);

	}

	
}
