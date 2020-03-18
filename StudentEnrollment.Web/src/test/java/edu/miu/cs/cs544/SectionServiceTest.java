package edu.miu.cs.cs544;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.miu.cs.cs544.group1.domain.Section;
import edu.miu.cs.cs544.group1.repository.SectionRepository;
import edu.miu.cs.cs544.group1.service.SectionService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SectionServiceTest {

	@Autowired
	SectionService sectionService;
	
	@MockBean
	SectionRepository sectionRepo;
	
	Section section = new Section();
	
	@Test
	public void createSectionTest() {
		when(sectionRepo.save(section)).thenReturn(section);
		assertEquals(section, sectionService.createSection(section));
	}
	
	@Test
	public void deleteSectionTest() {
		sectionService.deleteSection(section);
		verify(sectionRepo, times(1)).delete(section);
	}
}