package edu.miu.cs.cs544.group1.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.miu.cs.cs544.group1.domain.Address;
import edu.miu.cs.cs544.group1.repository.AddressRepository;
import edu.miu.cs.cs544.group1.service.impl.AdddessServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class AdddessServiceImplTest {

	@Autowired
	AdddessServiceImpl addressService;
	
	@MockBean
	AddressRepository addressRepo;
	
	Address a1 = new Address("1000 N 4th", "Fairfield", 52557, "USA");
	
	@Test
	public void addAddressTest() {
		when(addressRepo.save(a1)).thenReturn(a1);
		assertEquals(a1, addressService.addAddress(a1));
	}
	
//	@Test
//	public void getAddressTest() {
//		long id = 1;
//	}

}
