package com.SpringJwtTurf.models.response;

import com.SpringJwtTurf.documents.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserResponse {

    private UserResponse user;
    private String token;
    private String refreshToken;



}
