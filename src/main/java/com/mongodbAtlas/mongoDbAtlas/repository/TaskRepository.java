package com.mongodbAtlas.mongoDbAtlas.repository;

import com.mongodbAtlas.mongoDbAtlas.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    //Spring Data pueda inferir las consultas correctamente a partir de las propiedades de la entidad.
    List<Task> findBySeverity(int severity);

    //utiliza la anotación @Query para definir una consulta personalizada
    // en lugar de seguir la convención de nombres de Spring Data.

    //estás buscando documentos donde el campo assignee es igual al primer parámetro (?0) pasado al metodo
    @Query("{assignee: ?0 }")
    List<Task> getTaskByAssignee(String assignee);
}
