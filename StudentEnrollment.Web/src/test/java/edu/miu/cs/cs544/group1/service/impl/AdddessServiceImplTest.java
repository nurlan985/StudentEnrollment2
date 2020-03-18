package edu.miu.cs.cs544.group1.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.base.Optional;

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
	
	Address a1;
	Address a2;
	List<Address> addresses = new ArrayList<Address>();
	
	@BeforeEach
	public void addressInit() {
		a1 = new Address("1000 N 4th", "Fairfield", 52557, "USA");
		a2 = new Address("5th St", "Sprinfgield", 42311, "USA");
		a1.setId(1L);
		addresses.add(a1);
		addresses.add(a2);
	}
	
	@Test
	public void addAddressTest() {
		when(addressRepo.save(a1)).thenReturn(a1);
		assertEquals(a1, addressService.addAddress(a1));
	}
	
//	@Test
//	public void getAddressTest() {
//		when(addressRepo.findById(1L)).thenReturn(Optional.of(a1));
//		assertEquals(a1, addressService.getAddress(1));
//	}

}
