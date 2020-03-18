package edu.miu.cs.cs544.group1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.group1.domain.security.Person;
import edu.miu.cs.cs544.group1.service.SecurityService;

@RestController
@RequestMapping("/security")
public class SecurityController {
	@Autowired
	SecurityService securityService;

	@GetMapping(path="/people", produces = "application/json")
    public List<Person> getPeople() {
        return securityService.getPeople();
    }
	
	@GetMapping(path="/people-student", produces = "application/json")
	public List<Person> getPeopleStudent() {
		return securityService.getPeople();
	}
	@GetMapping(path="/people-faculty", produces = "application/json")
	public List<Person> getPeopleFaculty() {
		return securityService.getPeople();
	}

}
