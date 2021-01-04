package com.SpringJwtTurf.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserLoginResponse {
    private UserResponse userResponse;
    private String token;
    private String refreshToken;
}
