package edu.miu.cs.cs544.group1.service.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs544.group1.domain.security.Person;
import edu.miu.cs.cs544.group1.repository.PersonRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PersonRepository personRepository;
	
	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public UserDetails loadUserByUsername( String email) throws UsernameNotFoundException {
	    Person user = personRepository.findByEmail(email).orElse(null);
		UserBuilder builder = null;
	    if (user != null) {
	      builder = org.springframework.security.core.userdetails.User.withUsername(email);
	      builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
	      builder.roles(user.getRoles().parallelStream()
	    		  .map(role -> role.toString())
	    		  .collect(Collectors.toList())
	    		  .toArray(new String[0]));	// convert to list of strings and then to array
	    } else {
	      throw new UsernameNotFoundException("User Not Found.");
	    }
	    return builder.build();
	}
}
