package edu.miu.cs.cs544.group1.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs544.group1.domain.Course;


@Transactional(propagation = Propagation.MANDATORY)
public interface CourseRepository  extends JpaRepository<Course, Long>{

}
