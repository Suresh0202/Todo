package com.app.todo.controller;

import org.springframework.ui.Model;
import com.app.todo.com.app.todo.services.TaskServices;
import com.app.todo.models.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
//@RequestMapping("/tasks")

public class TaskController {
    private  final TaskServices taskService;
    public TaskController(TaskServices taskService)
    {
        this.taskService=taskService;
    }
    @GetMapping
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks); // Fixed typo (addAttribute)
        return "tasks"; // This will look for tasks.html in Thymeleaf templates
    }
    @PostMapping
    public String CreateTask(@RequestParam String title) {
       taskService.createTask(title);
        return "redirect:/"; // This will look for tasks.html in Thymeleaf templates
    }

    @GetMapping("/{id}/delete")
    public String deleteTasks(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/"; // This will look for tasks.html in Thymeleaf templates
    }

    @GetMapping("/{id}/toggle")
    public String toggleTasks(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/"; // This will look for tasks.html in Thymeleaf templates
    }


}
