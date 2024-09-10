package org.korb.task;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Set;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {

    private final TaskService taskService;

    public TaskResource(TaskService taskService) {
        this.taskService = taskService;
    }

    @GET
    @Path("/usuario/{id}")
    public Set<Task> getByUsuarioId(@PathParam("id")Long id){
        return taskService.findByUsuarioId(id);
    }

    @POST
    public Response create(TaskInputResource taskResource){
        try {
            taskService.create(taskResource);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Response.ok().build();
    }
}
