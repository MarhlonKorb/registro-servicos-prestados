package org.korb.task;

import org.korb.task.TaskInputResource;

import java.util.Set;

interface TaskService {
    void create(TaskInputResource taskInputResource) throws Exception;

    Set<Task> findByUsuarioId(Long idUsuario);
}
