package edu.miu.cs.cs544.group1.service;



import java.util.List;

import edu.miu.cs.cs544.group1.domain.Course;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;




public interface CourseService {
	
	public Course addCourses(Course courses);
	public List<Course> getCourses();
	public Course getCourse(long courseId) throws NoSuchResouceException;
	public Course updateCourse(long courseId, Course course);
	public void deleteCourse(long courseId);

}
