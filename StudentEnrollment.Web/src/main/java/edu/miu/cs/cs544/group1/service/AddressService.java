package edu.miu.cs.cs544.group1.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import edu.miu.cs.cs544.group1.domain.Address;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;

public interface AddressService {
	public Address addAddress(Address address);
	public List<Address> getAddresses();
	public Address getAddress(long addressId) throws NoSuchResouceException;
	public Address updateAddress(long addressId, Address address);
	public ResponseEntity<Void> deleteAddress(long addressId) throws NoSuchResouceException;;
}
