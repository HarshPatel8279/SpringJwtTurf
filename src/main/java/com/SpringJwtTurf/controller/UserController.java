package com.SpringJwtTurf.controller;

import com.SpringJwtTurf.models.request.CreateUserRequest;
import com.SpringJwtTurf.models.request.CustomerProfileUpdateRequest;
import com.SpringJwtTurf.models.request.UserLoginRequest;
import com.SpringJwtTurf.models.response.CreateUserLoginResponse;
import com.SpringJwtTurf.models.response.CreateUserResponse;
import com.SpringJwtTurf.models.response.CustomerProfileUpdateResponse;
import com.SpringJwtTurf.models.response.UserResponse;
import com.SpringJwtTurf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public CreateUserLoginResponse userLogin(@RequestBody UserLoginRequest userLoginRequest)
    {
        CreateUserLoginResponse createUserLoginResponse = userService.userLogin(userLoginRequest);

        return createUserLoginResponse;
    }

    @PostMapping("/updateProfile")
    public CustomerProfileUpdateResponse  customerProfileUpdate(@RequestBody CustomerProfileUpdateRequest customerProfileUpdateRequest){

         CustomerProfileUpdateResponse updateResponse = userService.updateCustomer(customerProfileUpdateRequest);

         return updateResponse;

    }

    @GetMapping("/hello")
    public String doHello(){
        return "Hey Harsh !!";
    }

}
