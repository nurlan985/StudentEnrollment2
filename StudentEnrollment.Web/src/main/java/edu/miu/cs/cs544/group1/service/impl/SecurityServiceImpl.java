package edu.miu.cs.cs544.group1.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs544.group1.domain.security.ChangePasswordModel;
import edu.miu.cs.cs544.group1.domain.security.Faculty;
import edu.miu.cs.cs544.group1.domain.security.Person;
import edu.miu.cs.cs544.group1.domain.security.Student;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;
import edu.miu.cs.cs544.group1.repository.FacultyRepository;
import edu.miu.cs.cs544.group1.repository.PersonRepository;
import edu.miu.cs.cs544.group1.repository.StudentRepository;
import edu.miu.cs.cs544.group1.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService{

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	FacultyRepository facultyRepository;
		
	@Override
	public boolean checkLogin(String email, String password) {
		List<Person> person = personRepository.findByEmailAndPassword(email, password);
		return(person.size() == 1);		
	}

	@Override
	public List<Person> getPeople() {
		return personRepository.findAll();
	}

	@Override
	public String changePassword(long id, ChangePasswordModel changePwd) {
		Person person = personRepository.findById(id).orElse(null);
		if(person != null) {
			String personPassword = person.getPassword();
			if(!personPassword.equals(changePwd.getOldPwd())) {
				return "Old password is not correct";
			}
			if(changePwd.getNewPwd().equals(changePwd.getConfirmPwd())) {
				person.setPassword(changePwd.getNewPwd());
				person = personRepository.save(person);
				return "Success";
			}
			return "Passwords dont match";
		}
		return "User does not exist";
	}
}
