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
import edu.miu.cs.cs544.group1.domain.Offering;
import edu.miu.cs.cs544.group1.domain.Section;
import edu.miu.cs.cs544.group1.service.OfferingService;
import edu.miu.cs.cs544.group1.service.SectionService;



@RestController
@RequestMapping(value="/offerings")
public class OfferingController {
	
	@Autowired
	OfferingService offeringService;

	@Autowired
	SectionService sectionService;
	
	@GetMapping(value="/")
	public ResponseEntity<List<Offering>> getCourses(){
		
		HttpHeaders headers = new HttpHeaders();
		
		List<Offering> offerings = offeringService.getOfferings();
		
		if(offerings == null) {
			return new ResponseEntity<List<Offering>>(HttpStatus.NOT_FOUND);
		}
		
		headers.add("Number Offerings returned is : ",String.valueOf(offerings.size()));
		
		return new ResponseEntity<List<Offering>>(offerings , headers, HttpStatus.OK);
		
	}
	
	@PostMapping(value="/")
	public ResponseEntity<Offering> addOfferings(@RequestBody Offering offering ){
		
		HttpHeaders headers = new HttpHeaders();
		
		if(offering == null) {
			
			return new ResponseEntity<Offering>(HttpStatus.BAD_REQUEST);
		}
		
		offeringService.addOfferings(offering);
		
		headers.add("Offering addded is :", String.valueOf(offering.getId()));
		
		
		return new ResponseEntity<Offering>(offering,headers,HttpStatus.CREATED);
		
	}
	
	@GetMapping(value="/{offeringId}")
	public ResponseEntity<Offering> getOffering(@PathVariable long offeringId){
		
		Offering offering =  offeringService.getOffering(offeringId);
		
		if(offering == null) {
			
			return new ResponseEntity<Offering>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Offering>(offering, HttpStatus.OK);
		
	}
	
	@PutMapping(value="/{offeringId}")
	public ResponseEntity<Offering> updateCourse(@PathVariable long offeringId,@RequestBody Offering offering){
		
		HttpHeaders headers = new HttpHeaders();
		
		Offering offering_toUpdate = offeringService.getOffering(offeringId);
		
		if(offering_toUpdate == null) {
			return new ResponseEntity<Offering>(HttpStatus.NOT_FOUND);
		}
		
		offeringService.updateOffering(offeringId, offering);
		
		headers.add("Updated Offering : ",String.valueOf(offeringId));
		
		return new ResponseEntity<Offering>(offering, headers,HttpStatus.OK);
	}
	

	@DeleteMapping(value="/{offeringId}")
	public ResponseEntity<Void> deleteCourse(@PathVariable long offeringId){

		offeringService.deleteOffering(offeringId);
		
		return  ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/sections/{offeringId}")
	public List<Section> getSections(@PathVariable long offeringId) {
		return sectionService.getSectionsByOfferingId(offeringId);
	}
}
