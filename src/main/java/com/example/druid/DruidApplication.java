package com.example.druid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class DruidApplication {

    private final UserService userService;

    public DruidApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DruidApplication.class, args);
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addUser() {
        User user = new User();
        user.setAddress("test");
        user.setUsername("test");
        userService.addUser(user);
        return "ok";
    }

    @RequestMapping("/select")
    @ResponseBody
    public String selectUser(@RequestParam("key") String conditionKey,
                             @RequestParam("value") String conditionValue) {
        return userService.selectUser(conditionKey, conditionValue);
    }

}
