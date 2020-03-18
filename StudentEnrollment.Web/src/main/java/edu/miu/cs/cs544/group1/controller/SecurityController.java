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
	@Autowired
	SecurityService securityService;

	@GetMapping(path="/people", produces = "application/json")
    public List<Person> getEmployees() {
        return securityService.getPeople();
    }

}
