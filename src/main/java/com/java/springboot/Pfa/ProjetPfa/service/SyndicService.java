package com.java.springboot.Pfa.ProjetPfa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.Pfa.ProjetPfa.Repository.SyndicRepository;
import com.java.springboot.Pfa.ProjetPfa.model.Syndic;



@Service
public class SyndicService {
	@Autowired
	SyndicRepository syndicRepository;
	

	public Syndic saveT(Syndic o) {
		return syndicRepository.save(o);
	}

	public Syndic updateT(Syndic o) {
		return syndicRepository.save(o);
	}

	public void delete(Syndic o) {
		syndicRepository.delete(o);
	}

	public void deletebyId(int id) {
		syndicRepository.deleteById(id);
	}

	public Syndic getbyId(int id) {
		return syndicRepository.findById(id).get();
	}

	public List<Syndic> getAll() {
		return syndicRepository.findAll();
	}

}
