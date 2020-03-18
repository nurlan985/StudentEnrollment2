package edu.miu.cs.cs544.group1.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.group1.domain.*;

@RestController
@EnableAutoConfiguration
public class MainController {

	@RequestMapping("/")
	public String home() {
		return "CS544. Group 1";
	}
}
