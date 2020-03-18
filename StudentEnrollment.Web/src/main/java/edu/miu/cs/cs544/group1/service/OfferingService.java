package edu.miu.cs.cs544.group1.service;



import java.util.List;

import org.springframework.http.ResponseEntity;

import edu.miu.cs.cs544.group1.domain.Offering;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;

public interface OfferingService {
	
	public Offering addOfferings(Offering offerings);
	public List<Offering> getOfferings();
	public Offering getOffering(long OfferingId) throws NoSuchResouceException;
	public Offering updateOffering(long offferingId, Offering offering);
	public ResponseEntity<Void>deleteOffering(long offeringId);
	
	public List<Offering> getOfferingsByCourseId(long courseId);
	public List<Offering> getOfferingsByBlockId(long blockId);

}
