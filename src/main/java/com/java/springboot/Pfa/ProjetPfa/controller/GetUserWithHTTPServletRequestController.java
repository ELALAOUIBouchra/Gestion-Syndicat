package com.java.springboot.Pfa.ProjetPfa.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.springboot.Pfa.ProjetPfa.Repository.UserRepository;
import com.java.springboot.Pfa.ProjetPfa.auth.UserService;

@Controller
public class GetUserWithHTTPServletRequestController {
	@Autowired
	private UserRepository userRepo;
 
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserNameSimple(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        
        return userRepo.findUserWithName(principal.getName()).get().getRole();
    }
   
}