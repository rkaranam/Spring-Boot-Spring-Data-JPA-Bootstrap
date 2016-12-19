package org.learnspring.samples.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController implements ErrorController {

	@RequestMapping(value = "/error")
	public String handleError() {
		return "Custom Error Handling";
	}
	
	@Override
	public String getErrorPath() {
		return null;
	}

}
