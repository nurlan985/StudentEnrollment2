package edu.miu.cs.cs544.group1.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs544.group1.domain.Address;
import edu.miu.cs.cs544.group1.domain.Course;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;
import edu.miu.cs.cs544.group1.repository.AddressRepository;
import edu.miu.cs.cs544.group1.service.AddressService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AdddessServiceImpl implements AddressService{

	@Autowired
	AddressRepository addressRepository;
	
	@Override
	public Address addAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address getAddress(long addressId) throws NoSuchResouceException {
		Address address = addressRepository.findById(addressId).orElseThrow(() -> 
		new NoSuchResouceException("No Address found  with" , addressId));
		
		return address;
	}

	@Override
	public Address updateAddress(long addressId, Address address_update) {
		Address address = addressRepository.findById(addressId).orElseThrow(() -> 
		new  NoSuchResouceException("No Address found  with" , addressId));
		
		address.setCity(address_update.getCity());
		address.setCountry(address_update.getCountry());
		address.setPostalCode(address_update.getPostalCode());
		address.setStreet(address_update.getStreet());
		
		Address updatedAddress = addressRepository.save(address);
		
		return updatedAddress;		
	}
	@Override
	public ResponseEntity<Void> deleteAddress(long addressId) throws NoSuchResouceException {

		Address address = addressRepository.findById(addressId)
				.orElseThrow(() -> new NoSuchResouceException("No Address found  with", addressId));

		addressRepository.delete(address);

		return ResponseEntity.noContent().build();

	}


	@Override
	public List<Address> getAddresses() {
		return addressRepository.findAll();
	}

}
