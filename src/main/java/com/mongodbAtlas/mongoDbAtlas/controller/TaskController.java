package com.mongodbAtlas.mongoDbAtlas.controller;

import com.mongodbAtlas.mongoDbAtlas.model.Task;
import com.mongodbAtlas.mongoDbAtlas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task agregarTask(@RequestBody Task task){
        return taskService.agregarTask(task);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Task> ObtenerListaTask(){
        return taskService.obtenerListaTask();
    }

    @GetMapping("/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public Task ObtenerTaskPorId(@PathVariable("taskId") String taskId){
        return taskService.obtenerTaskPorId(taskId);
    }

    @GetMapping("/importancia/{importancia}")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> obtenerTaskPorImportancia(@PathVariable("importancia") int importancia){
        return taskService.obtenerTaskPorImportancia(importancia);
    }
    @GetMapping("/asignado/{asignado}")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> obtenerTaskPorAsignado(@PathVariable("asignado") String importancia){
        return taskService.obtenerTaskPorAsignado(importancia);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Task actualizarTask(@RequestBody Task task){
        return taskService.actualizarTask(task);
    }
    @DeleteMapping("/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public String eliminarTask(@PathVariable("taskId") String taskId){
        return taskService.eliminarTask(taskId);
    }
}
