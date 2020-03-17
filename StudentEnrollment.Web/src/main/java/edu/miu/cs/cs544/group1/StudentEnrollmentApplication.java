package edu.miu.cs.cs544.group1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaRepositories("edu.miu.cs.cs544.group1.repository")
public class StudentEnrollmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentEnrollmentApplication.class, args);
	}

}