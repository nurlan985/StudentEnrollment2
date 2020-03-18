package edu.miu.cs.cs544.group1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs544.group1.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
