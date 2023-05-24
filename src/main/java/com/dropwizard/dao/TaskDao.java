package com.dropwizard.dao;

import com.dropwizard.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskDao {

    private List<Task> tasks;

    public TaskDao() {
        tasks = new ArrayList<>();
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public Optional<Task> findById(int id){
        return tasks.stream().filter(t -> t.getId() == id).findFirst();
    }
}
