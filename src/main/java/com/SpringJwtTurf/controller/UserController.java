package com.SpringJwtTurf.controller;

import com.SpringJwtTurf.models.request.CreateUserRequest;
import com.SpringJwtTurf.models.request.CustomerProfileUpdateRequest;
import com.SpringJwtTurf.models.request.UpdateBookedTimeSlotRequest;
import com.SpringJwtTurf.models.request.UserLoginRequest;
import com.SpringJwtTurf.models.response.*;
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

    @PutMapping("/updateProfile")
    public CustomerProfileUpdateResponse  customerProfileUpdate(@RequestBody CustomerProfileUpdateRequest customerProfileUpdateRequest){

         CustomerProfileUpdateResponse updateResponse = userService.updateCustomer(customerProfileUpdateRequest);

         return updateResponse;

    }

    @GetMapping("/booking-history")
    public AllBookedSlotsByUserResponse allBookedSlots(@RequestParam String username)
    {
        return userService.getAllBookedSlots(username);
    }

    @PostMapping("/update-booking")
    public TimeSlotResponse updateBookedSlot(@RequestBody UpdateBookedTimeSlotRequest updateBookedTimeSlotRequest)
    {
        TimeSlotResponse timeSlotResponse = this.userService.updateBookedSlot(updateBookedTimeSlotRequest);

        return timeSlotResponse;
    }


}
