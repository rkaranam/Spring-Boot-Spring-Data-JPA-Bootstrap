package org.learnspring.samples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Simple Spring MVC Controller for JSPs */

@Controller
public class MainController {

	@GetMapping("/")
	public String home() {
		return "index";
	}

}
