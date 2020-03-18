package edu.miu.cs.cs544.group1.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs544.group1.domain.Section;
import edu.miu.cs.cs544.group1.domain.security.Student;

@Repository
public interface SectionRepository extends JpaRepository<Section,Long>{

	public List<Section> findAllSectionsByCourseId(long courseId);
	public List<Section> findAllSectionsByBlockId(long blockId);
	public List<Section> findAllByOfferingId(long offeringId);
	public List<Section> findAllByFacultyId(long facultyId);
	public List<Section> findAllByStudentId(long studentId);
	
	public List<Student> findAllStudentsByFacultyIdAndSectionId(long facultyId, long sectionId);
	public List<Student> findAllStudentsBySectionId(long sectionId);
}
