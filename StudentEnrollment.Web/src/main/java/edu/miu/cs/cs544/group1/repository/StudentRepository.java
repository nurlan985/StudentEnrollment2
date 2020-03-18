package edu.miu.cs.cs544.group1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs544.group1.domain.security.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
	public Student findOneByEmail(String email);

}
