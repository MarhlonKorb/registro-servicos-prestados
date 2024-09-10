package org.korb.task;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class TaskRepository implements PanacheRepository<Task> {

    public void create(TaskInputDto taskInputDto) {
        persist(taskInputDto.convertToEntity());
    }

    // Método para encontrar tarefas por idUsuario
    public Set<Task> findByUsuarioId(Long idUsuario) {
        return find("usuario.id", idUsuario).stream().collect(Collectors.toSet());
    }
}
