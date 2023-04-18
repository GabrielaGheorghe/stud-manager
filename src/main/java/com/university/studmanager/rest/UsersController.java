package com.university.studmanager.rest;

import com.university.studmanager.domain.Users;
import com.university.studmanager.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService userService) {
        this.usersService = userService;
    }

    @PostMapping("/add")
    public void addUser(@RequestBody Users user) {
        this.usersService.addUser(user);
    }

}
