package org.learnspring.samples.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class SampleRestController {
	
	@RequestMapping("hello")
	public String printHello() {
		return "SampleRestController: printHello()";
	}

}
