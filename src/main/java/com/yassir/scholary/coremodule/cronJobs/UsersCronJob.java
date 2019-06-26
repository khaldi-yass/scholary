package com.yassir.scholary.coremodule.cronJobs;

import com.yassir.scholary.coremodule.services.UserService;
import com.yassir.scholary.coremodule.dtos.UserDto;
import com.yassir.scholary.coremodule.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersCronJob {

    @Autowired
    UserService userService;

    //    @Scheduled(cron = "0/30 * * * * ? *")
    //    @Scheduled(fixedRate = 5000)
    public void listAllUsers() {
        LogUtils.info(getClass(), "<UserList CronJob> started.");
        List<UserDto> userList = userService.findAll();
        StringBuilder stringBuilder = new StringBuilder();
        userList.forEach(userDto -> stringBuilder.append("Found " + userDto.getUsername() + ".\n"));
        LogUtils.info(getClass(), stringBuilder.toString());
        LogUtils.info(getClass(), "<UserList CronJob> finished");
    }
}
