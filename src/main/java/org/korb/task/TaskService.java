package org.korb.task;

import org.korb.task.TaskInputResource;

interface TaskService {
    void create(TaskInputResource taskInputResource) throws Exception;
}
