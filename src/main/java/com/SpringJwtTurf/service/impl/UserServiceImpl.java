package com.SpringJwtTurf.service.impl;

import com.SpringJwtTurf.documents.User;
import com.SpringJwtTurf.models.mics.CustomUserDetails;
import com.SpringJwtTurf.models.request.CreateUserRequest;
import com.SpringJwtTurf.models.response.CreateUserResponse;
import com.SpringJwtTurf.models.response.UserResponse;
import com.SpringJwtTurf.repository.UserRepository;
import com.SpringJwtTurf.service.UserService;
import com.SpringJwtTurf.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    private JwtTokenUtil jwtTokenUtil;
    private UserRepository userRepository;

    @Value("${jwt.secret.accessToken}")
    private String secretToken;

    @Value("${jwt.secret.refreshToken}")
    private String refreshSecret;

    @Value("${jwt.accessToken.validity}")
    private long secretTokenValidity;

    @Value("${jwt.refreshToken.validity}")
    private long refreshTokenValidity;

    @Autowired
    public UserServiceImpl(JwtTokenUtil jwtTokenUtil, UserRepository userRepository) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepository = userRepository;
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
}
