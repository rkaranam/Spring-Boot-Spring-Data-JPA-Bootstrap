package org.learnspring.samples.controller;

import java.util.Date;
import java.util.List;

import org.learnspring.samples.model.Task;
import org.learnspring.samples.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/home")
	public String printHello() {
		return "Welcome to Task Manager!";
	}
	
	@GetMapping("/all-tasks")
	public String allTasks() {
		List<Task> tasks = taskService.findAllTasks();
		return tasks.toString();
	}
	
	@GetMapping("/save-task")
	public String saveTask(@RequestParam String name, @RequestParam String desc) {
		Task task = new Task(name, desc, new Date(), false);
		taskService.saveTask(task);
		return "Task Saved Successfully!";
	}
	
	@GetMapping("/delete-task")
	public String deleteTask(@RequestParam int id) {
		taskService.deleteTask(id);
		return "Task Deleted Successfully!";
	}

}
