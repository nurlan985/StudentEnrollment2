package edu.miu.cs.cs544.group1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.group1.domain.security.Person;
import edu.miu.cs.cs544.group1.domain.security.PersonDetails;
import edu.miu.cs.cs544.group1.service.SecurityService;

@RestController
public class SecurityController {
    private static final Logger log = LogManager.getLogger(SecurityController.class);
	@Autowired
	SecurityService securityService;
	
	@PostMapping("/login")
	public String Login(Model model, HttpSession session) {
		log.info("postLogin()");
//		if(securityService.checkLogin(email, password)) {
//			model.addAttribute("currentUser", loggedInUser.getEmail());
//	        session.setAttribute("userId", loggedInUser.getId());
//			return "OK";
//		}
//		SecurityContext context = SecurityContextHolder.getContext();
//		Authentication auth = context.getAuthentication();
//        // read principal out of security context and set it to session
//        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) auth;
//        validatePrinciple(authentication.getPrincipal());
//        Person loggedInUser = ((PersonDetails) authentication.getPrincipal()).getUserDetails();
        		
		return "Fail";
	}

    private void validatePrinciple(Object principal) {
        if (!(principal instanceof PersonDetails)) {
            throw new  IllegalArgumentException("Principal can not be null!");
        }
    }
	@GetMapping(path="/people", produces = "application/json")
    public List<Person> getEmployees() {
        return securityService.getPeople();
    }

}
