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

import edu.miu.cs.cs544.group1.domain.Offering;
import edu.miu.cs.cs544.group1.repository.OfferingRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class OfferingServiceImplTest {

	@Autowired
	OfferingServiceImpl offeringService;
	
	@MockBean
	OfferingRepository offeringRepo;
	
	Offering offer1;
	Offering offer2;
	List<Offering> offerings = new ArrayList<>();
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		offer1 = new Offering();
		offer2 = new Offering();
		offerings.add(offer1);
		offerings.add(offer2);
	}

	@Test
	public void addOfferingsTest() {
		when(offeringRepo.save(offer1)).thenReturn(offer1);
		assertEquals(offer1, offeringService.addOfferings(offer1));
	}
	
	@Test
	public void getOfferingsTest() {
		when(offeringRepo.findAll()).thenReturn(offerings);
		assertEquals(2, offeringService.getOfferings().size());
	}

}
