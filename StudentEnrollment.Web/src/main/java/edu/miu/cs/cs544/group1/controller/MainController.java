package edu.miu.cs.cs544.group1.controller;

import java.security.Principal;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.group1.domain.*;

@RestController
@EnableAutoConfiguration
public class MainController extends BaseController {

	@RequestMapping("/")
	public String home() {
		return "CS544. Group 1";
	}
	
	@RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserNameSimple() {
        return getCurrentUserEmail();
    }
}
