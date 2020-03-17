package edu.miu.cs.cs544.group1.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.group1.service.OfferingService;



@RestController
public class OfferingController {
	
	@Autowired
	OfferingService offeringService;

	@DeleteMapping(value="offerings/{offeringId}")
	public ResponseEntity<Void> deleteCourse(@PathVariable long offeringId){

		offeringService.deleteOffering(offeringId);
		
		return  ResponseEntity.noContent().build();
	}

	
	

}
