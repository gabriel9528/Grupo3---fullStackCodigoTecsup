package com.mongodbAtlas.mongoDbAtlas.service;

import com.mongodbAtlas.mongoDbAtlas.model.Task;
import com.mongodbAtlas.mongoDbAtlas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task agregarTask(Task task){
        //Generación de un nuevo identificador único (taskId):
        //split("-")[0] toma la primera parte de la cadena antes del primer guion ("-").
        // Esto se hace para obtener una versión más corta y más legible del UUID="550e8400-e29b-41d4-a716-446655440000".
        task.setTaskId(UUID.randomUUID().toString().split("-")[1]);
        return taskRepository.save(task);
    }
    public List<Task> obtenerListaTask(){
        return taskRepository.findAll();
    }

    public Task obtenerTaskPorId(String taskId){
        //Optional<Task> optionalTask = taskRepository.findById(taskId);
        //return optionalTask.orElse(null);
        return taskRepository.findById(taskId).get();
    }

    public List<Task> obtenerTaskPorImportancia(int severity){
        return taskRepository.findBySeverity(severity);
    }

    public List<Task> obtenerTaskPorAsignado(String assignee){
        return taskRepository.getTaskByAssignee(assignee);
    }

    public Task actualizarTask(Task taskRequest){
        Task task = taskRepository.findById(taskRequest.getTaskId()).get();
        task.setDescription(taskRequest.getDescription());
        task.setSeverity(taskRequest.getSeverity());
        task.setAssignee(taskRequest.getAssignee());
        task.setStoryPoint(taskRequest.getStoryPoint());

        return taskRepository.save(task);
    }
    public String eliminarTask(String taskId){
        taskRepository.deleteById(taskId);
        return taskId+" Task eliminado correctamente ";
    }


}
