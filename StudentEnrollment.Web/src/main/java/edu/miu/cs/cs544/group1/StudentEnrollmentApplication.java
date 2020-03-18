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
import edu.miu.cs.cs544.group1.domain.Offering;
import edu.miu.cs.cs544.group1.domain.Section;
import edu.miu.cs.cs544.group1.domain.Semester;
import edu.miu.cs.cs544.group1.domain.security.Faculty;
import edu.miu.cs.cs544.group1.domain.security.Role;
import edu.miu.cs.cs544.group1.domain.security.Student;
import edu.miu.cs.cs544.group1.repository.BlockRepository;
import edu.miu.cs.cs544.group1.repository.CourseRepository;
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
			SectionRepository sectionRepository
			) {
		return (args) -> {
			Faculty nurlan = new Faculty("Nurlan", "nurlan985@gmail.com", "123",
					new HashSet<Role>(Arrays.asList(Role.ROLEFACULTY)), "Professor");
			nurlan = repository.save(nurlan);

			repository.save(new Faculty("Memar", "memar@gmail.com", "123456",
						new HashSet<Role>(Arrays.asList(Role.ROLEADMIN)), "super admin"));

            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
			Course course = new Course("CS544", "EA", "EA desc");
			course = courseRepository.save(course);
			Block block = new Block("2020-03", "March", Semester.SPRING, 3, df.parse("02/17/2020"), df.parse("03/17/2020"));
			block = blockRepository.save(block);
			Offering off = new Offering(course, block);
			off = offeringRepository.save(off);
			Section sec = new Section("CS544-2020-03-01", nurlan, off);
			
			sec = sectionRepository.save(sec);
		Student stu =new Student(
				"Julius", 
				"jjjingo@miu.edu",
				"12345",
				new HashSet<Role> (Arrays.asList(Role.ROLESTUDENT)),
				"610576");
		stu = studentRepository.save(stu);

			
		};
	}
}
