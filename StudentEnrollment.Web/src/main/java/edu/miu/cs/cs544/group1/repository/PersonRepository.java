package edu.miu.cs.cs544.group1.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs544.group1.domain.security.Person;
import edu.miu.cs.cs544.group1.domain.security.Student;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>{
	public Student findPersonByEmail(String email);
    public List<Person> findByEmailAndPassword(String email, String password);
    Optional<@Valid Person> findByEmail ( String email);
}
