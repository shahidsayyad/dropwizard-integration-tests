package com.dropwizard;

import com.dropwizard.config.AppConfiguration;
import com.dropwizard.dao.TaskDao;
import com.dropwizard.resource.TaskResource;
import com.dropwizard.service.TaskService;
import io.dropwizard.Application;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ToDoApplication extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new ToDoApplication().run(args);
    }

    @Override
    public void run(AppConfiguration appConfiguration, Environment environment) throws Exception {
        environment
                .jersey()
                .register(new TaskResource(new TaskService(new TaskDao())));
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
        super.initialize(bootstrap);
    }
}
