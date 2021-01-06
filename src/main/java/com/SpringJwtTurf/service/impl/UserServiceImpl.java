package com.SpringJwtTurf.service.impl;

import com.SpringJwtTurf.documents.CancelledSlot;
import com.SpringJwtTurf.enums.BookingStatus;
import com.SpringJwtTurf.exception.GeneralException;
import com.SpringJwtTurf.documents.BookedTimeSlot;
import com.SpringJwtTurf.documents.User;
import com.SpringJwtTurf.models.common.Address;
import com.SpringJwtTurf.models.common.Location;
import com.SpringJwtTurf.models.mics.CustomUserDetails;
import com.SpringJwtTurf.models.request.*;
import com.SpringJwtTurf.models.response.*;
import com.SpringJwtTurf.repository.BookedTimeSlotRepository;
import com.SpringJwtTurf.repository.CancelledSlotRepository;
import com.SpringJwtTurf.repository.UserRepository;
import com.SpringJwtTurf.service.UserService;
import com.SpringJwtTurf.utils.CommonUtilities;
import com.SpringJwtTurf.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
public class UserServiceImpl implements UserService {

    private JwtTokenUtil jwtTokenUtil;
    private UserRepository userRepository;
    private BookedTimeSlotRepository bookedTimeSlotRepository;
    private CancelledSlotRepository cancelledSlotRepository;

    @Value("${jwt.secret.accessToken}")
    private String secretToken;

    @Value("${jwt.secret.refreshToken}")
    private String refreshSecret;

    @Value("${jwt.accessToken.validity}")
    private long secretTokenValidity;

    @Value("${jwt.refreshToken.validity}")
    private long refreshTokenValidity;

    @Autowired
    public UserServiceImpl(JwtTokenUtil jwtTokenUtil, UserRepository userRepository,BookedTimeSlotRepository bookedTimeSlotRepository,CancelledSlotRepository cancelledSlotRepository) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepository = userRepository;
        this.bookedTimeSlotRepository = bookedTimeSlotRepository;
        this.cancelledSlotRepository = cancelledSlotRepository;
    }

    @Override
    public CreateUserResponse createNewUser(CreateUserRequest createUserRequest) {
        User addUser = new User();

        addUser.setNameOfUser(createUserRequest.getName());
        addUser.setPhoneNumber(createUserRequest.getPhoneNumber());
        addUser.setGender(createUserRequest.getGender());
        addUser.setDateOfBirth(createUserRequest.getDateOfBirth());
        addUser.setPassword(createUserRequest.getPassword());
        addUser.setCountryCode(createUserRequest.getCountryCode());
        addUser.setEmailId(createUserRequest.getEmailId());
        addUser.setDisplayImageUrl(createUserRequest.getDisplayImageUrl());
        addUser.setRole(createUserRequest.getRole());

        Location location = new Location();

        if(null!=createUserRequest && null!=createUserRequest.getLatitude() && null!=createUserRequest.getLongitude())
        {
            location.setType("Point");
            Double locationArray[] = new Double[2];
            locationArray[0] = createUserRequest.getLongitude();
            locationArray[1] = createUserRequest.getLatitude();
            location.setCoordinates(locationArray);
        }

        addUser.setLocation(location);


        User newCreatedUser = userRepository.insert(addUser);

        UserResponse userResponse = new UserResponse(newCreatedUser);
        CustomUserDetails customUserDetails = new CustomUserDetails(newCreatedUser);
        String token =
                jwtTokenUtil.generateToken
                        (newCreatedUser.getUsername(),customUserDetails,secretToken,secretTokenValidity);
        String refreshToken = jwtTokenUtil.generateToken(newCreatedUser.getUsername(), customUserDetails,refreshSecret,refreshTokenValidity);

        CreateUserResponse response = new CreateUserResponse(userResponse,token,refreshToken);

        return response;

    }

    @Override
    public CreateUserLoginResponse userLogin(UserLoginRequest userLoginRequest) {

        String username = userLoginRequest.getUsername();
        String password = userLoginRequest.getPassword();

        String userLoginType = CommonUtilities.findEmailIdOrPhoneValidator(userLoginRequest.getUsername());

        User isExist = null;
        if(userLoginType.equals("email"))
        {
            isExist= userRepository.findByEmailId(username,password);
        }
        else
        {
            isExist = userRepository.findUserByPhone(username,password);
        }

//        System.out.println(isExist);
//        System.out.println("Hiefnfk\nffhtththth\t\nynynynynyn");

        if(null!=isExist){
            CustomUserDetails customUserDetails = new CustomUserDetails(isExist);
            String token = jwtTokenUtil.generateToken(username,customUserDetails,secretToken,secretTokenValidity);
            String refreshToken = jwtTokenUtil.generateToken(username,customUserDetails,refreshSecret,refreshTokenValidity);



            UserResponse userResponse = new UserResponse(isExist);
            CreateUserLoginResponse loginResponse = new CreateUserLoginResponse(userResponse,token,refreshToken);

            return loginResponse;

        }
        else{
            throw new UsernameNotFoundException("User Name and password Does not Match");
        }

    }

    @Override
    public CustomerProfileUpdateResponse updateCustomer(CustomerProfileUpdateRequest customerProfileUpdateRequest) {
        User user = userRepository.findByPhoneNumber(customerProfileUpdateRequest.getPhoneNumber());
        System.out.println(user);
        if(null!=user)
        {
            user.setNameOfUser(customerProfileUpdateRequest.getName());
            user.setGender(customerProfileUpdateRequest.getGender());
            user.setPhoneNumber(customerProfileUpdateRequest.getPhoneNumber());
            user.setDateOfBirth(customerProfileUpdateRequest.getDateOfBirth());
            user.setAddress(new Address(customerProfileUpdateRequest.getAddressLine(),customerProfileUpdateRequest.getZipCode(),customerProfileUpdateRequest.getCity(),customerProfileUpdateRequest.getState(),"India"));
            user.setEmailId(customerProfileUpdateRequest.getEmailId());

            Double arr[] = new Double[2];
            arr[0]=customerProfileUpdateRequest.getLongitude();
            arr[1] = customerProfileUpdateRequest.getLatitude();

            user.setCountryCode(customerProfileUpdateRequest.getCountryCode());
            
            user.setLocation(new Location(user.getLocation().getType(),arr));
            

            User updatedUser= userRepository.save(user);

            UserResponse userResponse = new UserResponse(updatedUser);

            CustomerProfileUpdateResponse customerProfileUpdateResponse = new CustomerProfileUpdateResponse(userResponse);

            return customerProfileUpdateResponse;


        }
        else
        {
            throw new UsernameNotFoundException("User Not Found");
        }

    }

    @Override
    public AllBookedSlotsByUserResponse getAllBookedSlots(String username) {

//        System.out.println("Get"+username);
        User isExist = userRepository.findByPhoneNumber(username);

//        System.out.println(isExist);

        if(null!=isExist)
        {
            List<BookedTimeSlot> bookedTimeSlots = bookedTimeSlotRepository.findByUserId(username);
            AllBookedSlotsByUserResponse allBookedSlotsByUserResponse = new AllBookedSlotsByUserResponse(bookedTimeSlots);

            return allBookedSlotsByUserResponse;
        }
        else
        {
            throw new GeneralException("No UserFound with userId"+username, NOT_FOUND);
        }


    }

    @Override
    public TimeSlotResponse updateBookedSlot(UpdateBookedTimeSlotRequest updateBookedTimeSlotRequest) {
        BookedTimeSlot bookedTimeSlot = bookedTimeSlotRepository.findByBookingId(updateBookedTimeSlotRequest.getBookingId());
//        System.out.println("Hey"+bookedTimeSlot);
        BookedTimeSlot isSlotBooked = bookedTimeSlotRepository.findByTurfIdAndStartTime(updateBookedTimeSlotRequest.getTurfId(),updateBookedTimeSlotRequest.getStartTime());

        if(null!=isSlotBooked)
        {
            throw new GeneralException("Slot is Already Booked", OK);
        }

        if(null!=bookedTimeSlot)
        {
            bookedTimeSlot.setBookingId(CommonUtilities.getAlphaNumericString(6));
            bookedTimeSlot.setUserId(bookedTimeSlot.getUserId());
            bookedTimeSlot.setTurfId(updateBookedTimeSlotRequest.getTurfId());
            bookedTimeSlot.setPrice(updateBookedTimeSlotRequest.getPrice());
            bookedTimeSlot.setDate(updateBookedTimeSlotRequest.getDate());
            bookedTimeSlot.setStatus(BookingStatus.RESCHEDULED_BY_USER.name());
            bookedTimeSlot.setStartTime(updateBookedTimeSlotRequest.getStartTime());
            bookedTimeSlot.setEndTime(updateBookedTimeSlotRequest.getEndTime());
            bookedTimeSlot.setTimeStamp(LocalDateTime.now(ZoneId.of("Asia/Kolkata")));

            BookedTimeSlot updatedBookedSlot = bookedTimeSlotRepository.save(bookedTimeSlot);

            TimeSlotResponse timeSlotResponse = new TimeSlotResponse(updatedBookedSlot);

            return timeSlotResponse;
        }
        else {
            throw new GeneralException("Invalid Booking Id", OK);
        }
    }

    @Override
    @Transactional
    public TimeSlotResponse cancelBookedSlot(CancelOrUnavailableSlotRequest cancelOrUnavailableSlotRequest) {
        BookedTimeSlot bookedTimeSlot = bookedTimeSlotRepository.findByTurfIdAndStartTime(cancelOrUnavailableSlotRequest.getTurfId(),cancelOrUnavailableSlotRequest.getStartTime());

        if(null!=bookedTimeSlot){
            CancelledSlot cancelledSlot = new CancelledSlot(bookedTimeSlot);

            bookedTimeSlotRepository.deleteById(bookedTimeSlot.get_id());
            CancelledSlot savedSlotInDB = cancelledSlotRepository.insert(cancelledSlot);

            if(null!=savedSlotInDB){
                TimeSlotResponse response = new TimeSlotResponse(savedSlotInDB);

                return response;
            }
            else{
                throw new GeneralException("Error in Cancellation", INTERNAL_SERVER_ERROR);

            }

        }
        else {
            throw new GeneralException("No Booked Slot", OK);
        }

    }


}
