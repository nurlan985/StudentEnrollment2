package edu.miu.cs.cs544.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs544.domain.Offering;


@Repository
public interface OfferingRepository extends  JpaRepository<Offering,Long>{
	
	public List<Offering> getAll();

}
