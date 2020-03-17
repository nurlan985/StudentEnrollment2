package edu.miu.cs.cs544.group1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs544.group1.domain.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section,Long>{

}
