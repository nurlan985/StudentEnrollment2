package edu.miu.cs.cs544.group1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.group1.domain.Course;
import edu.miu.cs.cs544.group1.domain.Offering;
import edu.miu.cs.cs544.group1.domain.Section;
import edu.miu.cs.cs544.group1.service.CourseService;
import edu.miu.cs.cs544.group1.service.OfferingService;
import edu.miu.cs.cs544.group1.service.SectionService;



@RestController
@RequestMapping(value="/courses")
public class CourseController {

	@Autowired
	CourseService courseService;

	@Autowired
	SectionService sectionService;
	
	@Autowired
	OfferingService offeringService;
	
	
	@PostMapping(value = "/")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {

		HttpHeaders headers = new HttpHeaders();

		if (course == null) {
			return new ResponseEntity<Course>(HttpStatus.BAD_REQUEST);
		}
		courseService.addCourses(course);

		headers.add("Course added :", course.getCode());

		return new ResponseEntity<Course>(course, headers, HttpStatus.CREATED);

	}

	@GetMapping(value = "/")
	public ResponseEntity<List<Course>> getCourses() {

		HttpHeaders headers = new HttpHeaders();

		List<Course> courses = courseService.getCourses();

		if (courses == null) {
			return new ResponseEntity<List<Course>>(HttpStatus.NOT_FOUND);
		}
		headers.add("Number of Courses returned", String.valueOf(courses.size()));

		return new ResponseEntity<List<Course>>(courses, headers, HttpStatus.OK);
	}

	// get course by course id

	@GetMapping(value = "/{courseId}")
	public ResponseEntity<Course> getCourse(@PathVariable long courseId) {

		Course course = courseService.getCourse(courseId);

		if (course == null) {

			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}
	
	
	@PutMapping(value="/{courseId}")
	public ResponseEntity<Course> updateCourse(@PathVariable long courseId,@RequestBody Course course){
		
		HttpHeaders headers = new HttpHeaders();
		Course course_toUpdate = courseService.getCourse(courseId);
		
		if(course_toUpdate == null) {
			
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}
		
		courseService.updateCourse(courseId, course);
		
		headers.add("Updated Course : ",String.valueOf(courseId));
		
		return new ResponseEntity<Course>(course,headers, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{courseId}")
	public ResponseEntity<Void> deleteCourse(@PathVariable long courseId){

		courseService.deleteCourse(courseId);
		
		return  ResponseEntity.noContent().build();
	}
	

	@GetMapping(value = "/{courseId}/sections")
	public List<Section> getSections(long courseId) {
		return sectionService.getSectionsByCourseId(courseId);
	}
	
	@GetMapping(value = "/{courseId}/offerings")
	public List<Offering> getOfferings(long courseId) {
		return offeringService.getOfferingsByCourseId(courseId);
	}

}
