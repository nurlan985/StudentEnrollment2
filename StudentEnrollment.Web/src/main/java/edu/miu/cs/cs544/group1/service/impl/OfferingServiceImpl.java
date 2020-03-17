 package edu.miu.cs.cs544.group1.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs544.group1.domain.Offering;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;
import edu.miu.cs.cs544.group1.repository.OfferingRepository;
import edu.miu.cs.cs544.group1.service.OfferingService;


;

@Service
@Transactional
public class OfferingServiceImpl implements OfferingService {

	@Autowired
	OfferingRepository offeringRepository;

	@Override
	public Offering addOfferings(Offering offerings) {

		return offeringRepository.save(offerings);
	}

	@Override
	public List<Offering> getOfferings() {

		return offeringRepository.findAll();
	}

	@Override
	public Offering getOffering(long OfferingId) throws NoSuchResouceException {

		Offering offering = offeringRepository.findById(OfferingId)
				.orElseThrow(() -> new NoSuchResouceException("No Offering with id :", OfferingId));

		return offering;
	}
	
	
	
	@Override
	public Offering updaeOffering(long offferingId, Offering offering_update) {

		Offering offering = offeringRepository.findById(offferingId)
				.orElseThrow(() -> new NoSuchResouceException("No Offering with id :", offferingId));
		
		offering.setBlock(offering_update.getBlock());
		offering.setCourse(offering_update.getCourse());
		
		Offering updatedOffering = offeringRepository.save(offering);
		
		return updatedOffering;
	}

	@Override
	public void deleteOffering(long offeringId) throws NoSuchResouceException {

		Offering offering = offeringRepository.findById(offeringId)
				.orElseThrow(() -> new NoSuchResouceException("No Offering with id :", offeringId));

		offeringRepository.delete(offering);
	}

	

}
