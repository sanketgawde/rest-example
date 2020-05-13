package com.msprime.crudservice.controller;

import com.msprime.crudservice.model.UserJson;
import com.msprime.crudservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class UserController {

    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public UserJson getUserDetails(@PathVariable("id") String userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/users")
    public List<UserJson> getUserList() {
        return userService.getUserList();
    }

    @PostMapping("/users")
    public UserJson addUser(@RequestBody UserJson userJson) {
        return userService.addUser(userJson);
    }
}
