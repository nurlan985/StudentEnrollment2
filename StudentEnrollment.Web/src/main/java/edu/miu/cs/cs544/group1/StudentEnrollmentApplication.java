package edu.miu.cs.cs544.group1;

import java.util.Arrays;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.miu.cs.cs544.group1.domain.security.Faculty;
import edu.miu.cs.cs544.group1.domain.security.Role;
import edu.miu.cs.cs544.group1.repository.FacultyRepository;

@SpringBootApplication
//@EnableJpaRepositories("edu.miu.cs.cs544.group1.repository")
public class StudentEnrollmentApplication {

	  private static final Logger log = LoggerFactory.getLogger(StudentEnrollmentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StudentEnrollmentApplication.class, args);
	}

	@Bean
  public CommandLineRunner demo(FacultyRepository repository) {
    return (args) -> {

      repository.save(
    		  new Faculty(
    				  "Nurlan", 
    				  "nurlan985@gmail.com", 
    				  "123", 
    				  new HashSet<Role>(Arrays.asList(Role.ROLEADMIN)), 
    				  "Professor"));

    };
  }
}
