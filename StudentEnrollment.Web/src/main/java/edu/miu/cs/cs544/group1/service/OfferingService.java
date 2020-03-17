package edu.miu.cs.cs544.group1.service;



import java.util.List;

import edu.miu.cs.cs544.group1.domain.Offering;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;



public interface OfferingService {
	
	public Offering addOfferings(Offering offerings);
	public List<Offering> getOfferings();
	public Offering getOffering(long OfferingId) throws NoSuchResouceException;
	public Offering updaeOffering(long offferingId, Offering offering);
	public void deleteOffering(long offeringId);
	

}
