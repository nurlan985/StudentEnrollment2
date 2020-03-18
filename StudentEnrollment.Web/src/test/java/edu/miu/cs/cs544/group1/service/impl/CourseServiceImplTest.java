package edu.miu.cs.cs544.group1.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
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
	
	@Test
	public void addCourseTest() {
		Course c1 = new Course();	
		c1.setCode("cs544");
		c1.setDescription("Enterprise Architecture");
		c1.setName("EA");
		
		when(courseRepo.save(c1)).thenReturn(c1);
		assertEquals(c1, courseService.addCourses(c1));
	}

}
