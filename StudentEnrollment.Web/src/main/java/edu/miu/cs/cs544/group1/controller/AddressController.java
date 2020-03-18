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

import edu.miu.cs.cs544.group1.domain.Address;
import edu.miu.cs.cs544.group1.service.AddressService;


@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@PostMapping(value = "/")
	public ResponseEntity<Address> addAddress(@RequestBody Address address) {

		HttpHeaders headers = new HttpHeaders();

		if (address == null) {
			return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
		}
		addressService.addAddress(address);

		headers.add("Address added :", address.getId()+ "");

		return new ResponseEntity<Address>(address, headers, HttpStatus.CREATED);

	}

	@GetMapping(value = "/")
	public ResponseEntity<List<Address>> getAddresses() {

		HttpHeaders headers = new HttpHeaders();

		List<Address> addresses = addressService.getAddresses();

		if (addresses == null) {
			return new ResponseEntity<List<Address>>(HttpStatus.NOT_FOUND);
		}
		headers.add("Number of Addresses returned", String.valueOf(addresses.size()));

		return new ResponseEntity<List<Address>>(addresses, headers, HttpStatus.OK);
	}

	// get address by address ID

	@GetMapping(value = "/{addressId}")
	public ResponseEntity<Address> getAddress(@PathVariable long addressId) {

		Address address = addressService.getAddress(addressId);

		if (address == null) {

			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}
	
	
	@PutMapping(value="/{addressId}")
	public ResponseEntity<Address> updateAddress(@PathVariable long addressId,@RequestBody Address address){
		
		HttpHeaders headers = new HttpHeaders();
		Address address_toUpdate = addressService.getAddress(addressId);
		
		if(address_toUpdate == null) {
			
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
		
		addressService.updateAddress(addressId, address);
		
		headers.add("Updated Address : ",String.valueOf(addressId));
		
		return new ResponseEntity<Address>(address,headers, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{addressId}")
	public ResponseEntity<Void> deleteAddress(@PathVariable long addressId){

		addressService.deleteAddress(addressId);
		
		return  ResponseEntity.noContent().build();
	}
}
