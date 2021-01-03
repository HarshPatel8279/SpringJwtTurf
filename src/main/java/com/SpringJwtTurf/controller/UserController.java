package com.SpringJwtTurf.controller;

import com.SpringJwtTurf.models.request.CreateUserRequest;
import com.SpringJwtTurf.models.response.CreateUserResponse;
import com.SpringJwtTurf.models.response.UserResponse;
import com.SpringJwtTurf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest createUserRequest)
    {
        return userService.createNewUser(createUserRequest);
    }

}
