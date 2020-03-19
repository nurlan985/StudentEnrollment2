package edu.miu.cs.cs544.group1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.group1.domain.security.ChangePasswordModel;
import edu.miu.cs.cs544.group1.domain.security.Person;
import edu.miu.cs.cs544.group1.service.SecurityService;

@RestController
@RequestMapping("/security")
public class SecurityController extends BaseController {
	@Autowired
	SecurityService securityService;

	@PutMapping("/change-password")
	public String changePassword(@RequestBody ChangePasswordModel changePwd) {
		Person person = getCurrentPerson();
		return securityService.changePassword(person.getId(), changePwd);
	}

}
