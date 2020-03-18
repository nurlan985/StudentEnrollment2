package edu.miu.cs.cs544.group1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import edu.miu.cs.cs544.group1.domain.security.Student;
import edu.miu.cs.cs544.group1.repository.StudentRepository;
import edu.miu.cs.cs544.group1.service.IAuthenticationFacade;

public abstract class BaseController {
	@Autowired
	private IAuthenticationFacade authenticationFacade;
	@Autowired
	private StudentRepository studentRepository;
	
	protected Student getCurrentStudent() {
		return studentRepository.findOneByEmail(getCurrentUserEmail());
	}
	protected String getCurrentUserEmail() {
		Authentication authentication = authenticationFacade.getAuthentication();
        return authentication.getName();
	}
}
