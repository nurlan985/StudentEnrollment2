package edu.miu.cs.cs544.group1.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.miu.cs.cs544.group1.domain.Course;
import edu.miu.cs.cs544.group1.repository.CourseRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class CourseServiceImplTest {

	@Autowired
	CourseServiceImpl courseService;

	@MockBean
	CourseRepository courseRepo;

	Course c1;

	List<Course> courses = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		c1 = new Course();
		c1.setCode("cs544");
		c1.setDescription("Enterprise Architecture");
		c1.setName("EA");
		courses.add(c1);
	}

	@Test
	public void addCourseTest() {
		when(courseRepo.save(c1)).thenReturn(c1);
		assertEquals(c1, courseService.addCourses(c1));
	}

	@Test
	public void getCoursesTest()throws Exception  {
		when(courseRepo.findAll()).thenReturn(courses);
		assertEquals(1, courseService.getCourses().size());

	}
}
