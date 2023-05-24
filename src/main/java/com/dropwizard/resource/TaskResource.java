package com.dropwizard.resource;

import com.dropwizard.model.GenericResponse;
import com.dropwizard.model.Task;
import com.dropwizard.service.TaskService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/task")
@Produces(MediaType.APPLICATION_JSON)
public class TaskResource {

    private TaskService taskService;

    public TaskResource(TaskService taskService) {
        this.taskService = taskService;
    }

    @GET
    @Path("{id}")
    public GenericResponse<Task> getTask(@PathParam("id") int taskId) {
        return taskService.getTask(taskId);
    }

    @POST
    public GenericResponse<Task> createTask(Task task) {
        return taskService.createTask(task);
    }
}
