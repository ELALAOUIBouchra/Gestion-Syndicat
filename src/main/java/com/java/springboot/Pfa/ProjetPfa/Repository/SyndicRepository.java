package com.java.springboot.Pfa.ProjetPfa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.springboot.Pfa.ProjetPfa.model.Syndic;


@Repository

public interface SyndicRepository extends JpaRepository<Syndic, Integer> {

}
