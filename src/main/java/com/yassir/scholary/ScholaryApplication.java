package com.yassir.scholary;

import com.yassir.scholary.services.UserService;
import com.yassir.scholary.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScholaryApplication implements ApplicationRunner {

    @Value("${com.yassir.environement:Local environment}")
    private String applicationEnvironment;

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ScholaryApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LogUtils.info(getClass(), "Application started in " + applicationEnvironment);
        //initialize();
    }

    private void initialize() {
        userService.deleteAll();
        userService.resetId();
        userService.generateDummyData(10);
    }
}
