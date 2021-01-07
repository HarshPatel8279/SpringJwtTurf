package com.SpringJwtTurf.controller;

import com.SpringJwtTurf.documents.BookedTimeSlot;
import com.SpringJwtTurf.documents.OpenCloseTime;
import com.SpringJwtTurf.models.AllSlot;
import com.SpringJwtTurf.models.request.*;
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

    @PostMapping("/cancel-booking")
    public TimeSlotResponse cancelBookedSlot(@RequestBody CancelOrUnavailableSlotRequest cancelOrUnavailableSlotRequest){
        TimeSlotResponse response = this.userService.cancelBookedSlot(cancelOrUnavailableSlotRequest);

        return response;
    }

    @PostMapping("/get-all-slots-by-date")
    public GetAllSlotsResponse getAllSlotsByDate(@RequestBody GetAllSlotsRequest getAllSlotsRequest){
        System.out.println("GetAllSlotsByDate");
        GetAllSlotsResponse getAllSlotsResponse = this.userService.getAllSlotsByDate(getAllSlotsRequest);
        return getAllSlotsResponse;
    }

//    @PostMapping("/addOpenClose")
//    public void addOpenClose(@RequestBody OpenCloseTime openCloseTime)
//    {
//        this.userService.addOpenClose(openCloseTime);
//    }

    @PostMapping("/addBookedTimeSlot")
    public BookedTimeSlot addBookedTimeSlot(@RequestBody BookedTimeSlot bookedTimeSlot){

        return this.userService.addBookedTimeSlot(bookedTimeSlot);

    }

    @PostMapping("/get-available-slots")
    public void getAllSlot(@RequestBody AllSlot allSlot)
    {
        this.userService.getAllSlot(allSlot);
    }
}
