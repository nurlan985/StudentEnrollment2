package edu.miu.cs.cs544.group1.service;

import edu.miu.cs.cs544.group1.domain.Address;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;

public interface AddressService {
	public Address addAddress(Address address);
	public Address getAddress(long addressId) throws NoSuchResouceException;
	public Address updateAddress(long addressId, Address address);
	public boolean deleteAddress(long addressId);
}
