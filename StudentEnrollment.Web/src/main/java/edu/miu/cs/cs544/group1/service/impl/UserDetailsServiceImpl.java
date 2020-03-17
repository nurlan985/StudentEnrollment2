package edu.miu.cs.cs544.group1.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs544.group1.domain.security.Person;
import edu.miu.cs.cs544.group1.domain.security.PersonDetails;
import edu.miu.cs.cs544.group1.repository.PersonRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	 private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	    @Autowired
	    private PersonRepository personRepository;
	    @Transactional(readOnly = true)
	    @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        Person user = personRepository.findByEmail(email);
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found.");
	        }
	        log.info("findByEmail() : {}", email);
	        return new PersonDetails(user);
	    }

}
