package org.learnspring.samples.controller;

import java.util.List;

import org.learnspring.samples.model.Task;
import org.learnspring.samples.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping("/home")
	public String printHello() {
		return "Welcome to Task Manager!";
	}
	
	@RequestMapping("/all-tasks")
	public String allTasks() {
		List<Task> tasks = taskService.findAllTasks();
		return tasks.toString();
	}

}
