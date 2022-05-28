package com.java.springboot.Pfa.ProjetPfa.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.springboot.Pfa.ProjetPfa.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	 @Query(" select u from User u " +
	            " where u.username = ?1")
	    Optional<User> findUserWithName(String username);

}
