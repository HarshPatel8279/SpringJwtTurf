package com.SpringJwtTurf.config;

import com.SpringJwtTurf.repository.UserRepository;
import com.SpringJwtTurf.utils.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private JwtTokenUtil jwtTokenUtil;
    private UserRepository userRepository;


    @Value("${jwt.secret.accessToken}")
    private String accessToken;

    @Value("${jwt.secret.refreshToken}")
    private String refreshToken;

    @Autowired
    public JwtRequestFilter(JwtTokenUtil jwtTokenUtil, UserRepository userRepository) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepository = userRepository;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        final String authorizationHeader = httpServletRequest.getHeader("Authorization");

        System.out.println(authorizationHeader);

        UserDetails userDetails = null;
        String jwt = null;

        if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")){
            jwt = authorizationHeader.substring(7);
//            System.out.println(jwt);
            try
            {
                userDetails = new User(jwtTokenUtil.getUsernameFromToken(jwt,accessToken),"", jwtTokenUtil.getRolesFromToken(jwt,accessToken));
            }
            catch (IllegalArgumentException iae)
            {
                logger.error(iae+"Unable to get JwtToken");
            }
            catch (ExpiredJwtException eje){
                logger.error(eje+"Token Expired");
            }

        }
        else
        {
            logger.warn("Jwt Token doesn't start with Bearer");
        }

        if(userDetails!=null){
            if(jwtTokenUtil.validateToken(jwt,userDetails.getUsername(),accessToken)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);

    }
}
