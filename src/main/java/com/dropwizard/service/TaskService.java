package com.dropwizard.service;

import com.dropwizard.dao.TaskDao;
import com.dropwizard.model.GenericResponse;
import com.dropwizard.model.Task;

public class TaskService {

    private TaskDao taskDao;

    public TaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public GenericResponse<Task> createTask(Task task) {
        taskDao.add(task);
        return GenericResponse.<Task>builder().success(true).data(task).build();
    }

    public GenericResponse<Task> getTask(int id) {
        Task task = taskDao.findById(id).orElseThrow();
        return GenericResponse.<Task>builder().success(true).data(task).build();
    }
}
