package edu.miu.cs.cs544.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs544.domain.Entry;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long>{

}
