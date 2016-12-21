package org.learnspring.samples.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.learnspring.samples.model.Task;
import org.learnspring.samples.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* Spring MVC Controller for JSPs */

@Controller
public class MainController {
	
	@Autowired
	private TaskService taskService;

	@GetMapping("/")
	public String home(HttpServletRequest request) {
		request.setAttribute("taskType", "HOME");
		return "index";
	}
	
	@GetMapping("/all-tasks")
	public String allTasks(HttpServletRequest request) {
		request.setAttribute("tasks", taskService.findAllTasks());
		request.setAttribute("taskType", "ALL_TASKS");
		return "index";
	}
	
	@GetMapping("/new-task")
	public String newTask(HttpServletRequest request) {
		request.setAttribute("taskType", "NEW_TASK");
		return "index";
	}
	
	@PostMapping("/save-task")
	public String saveTask(@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest request) {
		task.setDateCreated(new Date());
		taskService.saveTask(task);
		request.setAttribute("tasks", taskService.findAllTasks());
		request.setAttribute("taskType", "ALL_TASKS");
		return "index";
	}
	
	@GetMapping("/update-task")
	public String updateTask(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("task", taskService.findTask(id));
		request.setAttribute("taskType", "UPDATE_TASK");
		return "index";
	}
	
	@GetMapping("/delete-task")
	public String deleteTask(@RequestParam int id, HttpServletRequest request) {
		taskService.deleteTask(id);
		request.setAttribute("tasks", taskService.findAllTasks());
		request.setAttribute("taskType", "ALL_TASKS");
		return "index";
	}

}
