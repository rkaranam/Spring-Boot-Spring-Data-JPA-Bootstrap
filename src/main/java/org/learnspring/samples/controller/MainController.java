package org.learnspring.samples.controller;

import java.util.List;

import org.learnspring.samples.model.Task;
import org.learnspring.samples.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/all-tasks")
	public @ResponseBody String allTasks() {
		List<Task> tasks = taskService.findAllTasks();
		return tasks.toString();
	}

}
