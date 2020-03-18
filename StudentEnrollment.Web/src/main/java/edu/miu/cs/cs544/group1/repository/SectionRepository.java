package edu.miu.cs.cs544.group1.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs544.group1.domain.Section;

@Repository
@Transactional()
public interface SectionRepository extends JpaRepository<Section,Long>{

}
