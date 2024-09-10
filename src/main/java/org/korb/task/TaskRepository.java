package org.korb.task;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TaskRepository implements PanacheRepository<Task> {

    public void create(TaskInputDto taskInputDto){
        persist(taskInputDto.convertToEntity());
    }
}
