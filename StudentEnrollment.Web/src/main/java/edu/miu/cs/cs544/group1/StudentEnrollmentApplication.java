package edu.miu.cs.cs544.group1;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import edu.miu.cs.cs544.group1.domain.Block;
import edu.miu.cs.cs544.group1.domain.Course;
import edu.miu.cs.cs544.group1.domain.Entry;
import edu.miu.cs.cs544.group1.domain.Offering;
import edu.miu.cs.cs544.group1.domain.Section;
import edu.miu.cs.cs544.group1.domain.Semester;
import edu.miu.cs.cs544.group1.domain.security.Faculty;
import edu.miu.cs.cs544.group1.domain.security.Role;
import edu.miu.cs.cs544.group1.domain.security.Student;
import edu.miu.cs.cs544.group1.repository.BlockRepository;
import edu.miu.cs.cs544.group1.repository.CourseRepository;
import edu.miu.cs.cs544.group1.repository.EntryRepository;
import edu.miu.cs.cs544.group1.repository.FacultyRepository;
import edu.miu.cs.cs544.group1.repository.OfferingRepository;
import edu.miu.cs.cs544.group1.repository.SectionRepository;
import edu.miu.cs.cs544.group1.repository.StudentRepository;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class StudentEnrollmentApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentEnrollmentApplication.class, args);
	}

	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/*"))
				.apis(RequestHandlerSelectors.basePackage("edu.miu.cs.cs544.gourp1")).build();
	}

	@Bean
	public CommandLineRunner demo(
			FacultyRepository repository, 
			StudentRepository studentRepository,
			CourseRepository courseRepository,
			BlockRepository blockRepository,
			OfferingRepository offeringRepository,
			SectionRepository sectionRepository,
			EntryRepository entryRepository
			) {
		return (args) -> {
			Faculty nurlan = new Faculty("Nurlan", "nurlan985@gmail.com", "123",
					new HashSet<Role>(Arrays.asList(Role.ROLEFACULTY)), "Professor");
			nurlan = repository.save(nurlan);

			repository.save(new Faculty("Memar", "memar@gmail.com", "123456",
						new HashSet<Role>(Arrays.asList(Role.ROLEADMIN)), "super admin"));

            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
			Course course = new Course("CS544", "EA", "EA desc");
			Course course2 = new Course("CS555", "MWA", "MWA desc");
			Course course3 = new Course("CS427", "WAP", "WAP desc");
			course = courseRepository.save(course);
			course2 = courseRepository.save(course2);
			course3 = courseRepository.save(course3);
			Block block = new Block("2020-03", "March", Semester.SPRING, 3, df.parse("02/17/2020"), df.parse("03/17/2020"));
			Block block2 = new Block("2020-04", "April", Semester.SPRING, 4, df.parse("03/17/2020"), df.parse("04/17/2020"));
			Block block3 = new Block("2020-05", "May", Semester.SPRING, 5, df.parse("04/17/2020"), df.parse("05/17/2020"));
			block = blockRepository.save(block);
			block2 = blockRepository.save(block2);
			block3 = blockRepository.save(block3);
			Offering off = new Offering(course, block);
			Offering off2 = new Offering(course2, block2);
			Offering off3 = new Offering(course3, block3);
			off = offeringRepository.save(off);
			off2 = offeringRepository.save(off2);
			off3 = offeringRepository.save(off3);
			
			Section sec = new Section("CS544-2020-03-01", nurlan, off);
			Section sec2 = new Section("CS555-2020-04-01", nurlan, off2);
			Section sec3 = new Section("CS427-2020-05-01", nurlan, off3);
			
			sec = sectionRepository.save(sec);
			sec2 = sectionRepository.save(sec2);
			sec3 = sectionRepository.save(sec3);

			Entry entry = new Entry("November 2019", df.parse("11/01/2019"), df.parse("01/30/2020"), df.parse("03/20/2020"));
			entry = entryRepository.save(entry);
			
			Student stu =new Student(
					"Julius", 
					"jjjingo@miu.edu",
					"12345",
					new HashSet<Role> (Arrays.asList(Role.ROLESTUDENT)),
					"610576");
			stu.addSection(sec);
			stu.addSection(sec2);
			stu.setEntry(entry);
			stu = studentRepository.save(stu);
	
		};
	}
}
