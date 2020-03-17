package edu.miu.cs.cs544.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.domain.*;

@RestController
@EnableAutoConfiguration
public class MainController {

	 @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }
}
