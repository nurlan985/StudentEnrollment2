package edu.miu.cs.cs544.group1.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import edu.miu.cs.cs544.group1.StudentEnrollmentApplication;

public class ServeletInitializer extends SpringBootServletInitializer {
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StudentEnrollmentApplication.class);
    }
}
