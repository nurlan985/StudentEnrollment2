package edu.miu.cs.cs544.group1.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs544.group1.domain.Course;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;
import edu.miu.cs.cs544.group1.repository.CourseRepository;
import edu.miu.cs.cs544.group1.service.CourseService;



@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Override
	public Course addCourses(Course courses) {

		return courseRepository.save(courses);
	}

	@Override
	public List<Course> getCourses() {

		return courseRepository.findAll();
	}

	@Override
	public Course getCourse(long courseId) throws NoSuchResouceException {
		Course course = courseRepository.findById(courseId).orElseThrow(() -> new NoSuchResouceException("No Course found  with" , courseId));

		return course;
	}

	@Override
	public Course updateCourse(long courseId, Course course_update) throws NoSuchResouceException {
		
		Course course = courseRepository.findById(courseId).orElseThrow(() -> new  NoSuchResouceException("No Course found  with" , courseId));
		
		course.setCode(course_update.getCode());
		course.setName(course_update.getName());
		course.setDescription(course_update.getDescription());
		
		Course updatedCourse = courseRepository.save(course);
		
		return updatedCourse;
	}

	@Override
	public void deleteCourse(long courseId)throws NoSuchResouceException {
		
		Course course = courseRepository.findById(courseId).orElseThrow(() -> new NoSuchResouceException("No Course found  with" , courseId));
		
		courseRepository.delete(course);
		

	}

}
