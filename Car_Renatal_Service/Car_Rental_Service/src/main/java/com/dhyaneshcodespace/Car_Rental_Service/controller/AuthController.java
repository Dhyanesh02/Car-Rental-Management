package com.dhyaneshcodespace.Car_Rental_Service.controller;

import com.dhyaneshcodespace.Car_Rental_Service.dto.AuthenticationRequest;
import com.dhyaneshcodespace.Car_Rental_Service.dto.AuthenticationResponse;
import com.dhyaneshcodespace.Car_Rental_Service.dto.SignupRequest;
import com.dhyaneshcodespace.Car_Rental_Service.dto.UserDto;
import com.dhyaneshcodespace.Car_Rental_Service.entity.User;
import com.dhyaneshcodespace.Car_Rental_Service.repository.UserRepository;
import com.dhyaneshcodespace.Car_Rental_Service.services.auth.AuthService;
import com.dhyaneshcodespace.Car_Rental_Service.services.auth.AuthServiceImpl;
import com.dhyaneshcodespace.Car_Rental_Service.services.jwt.UserService;
import com.dhyaneshcodespace.Car_Rental_Service.utils.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceImpl authService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private  final JWTUtil jwtUtil;
    private final UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<?>signupCustomer(@RequestBody SignupRequest signupRequest){
        if(authService.hasCustomerWithEmail(signupRequest.getEmail()))
            return new ResponseEntity<>("Customer already exists with this email address",HttpStatus.NOT_ACCEPTABLE);
        UserDto createCustomerDto = authService.createCustomer(signupRequest);
        if(createCustomerDto == null)
            return new ResponseEntity<>( "Customer not created, Come again later", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(createCustomerDto, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)throws
        BadCredentialsException,
                DisabledException,
                UsernameNotFoundException{
            try{
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()));
            }
            catch(BadCredentialsException e){
                throw new BadCredentialsException("Incorrect username or password");
            }
            final UserDetails userDetails = userService.userDetailsService().loadUserByUsername(authenticationRequest.getEmail());
            Optional<User> optionalUser = userRepository.findFirstByEmail(userDetails.getUsername());
            final String jwt = jwtUtil.generateToken(userDetails);
            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            if(optionalUser.isPresent()){
                authenticationResponse.setJwt(jwt);
                authenticationResponse.setUserId(optionalUser.get().getId());
                authenticationResponse.setUserRole(optionalUser.get().getUserRole());
            }
            return authenticationResponse;
        }
    @PostMapping("/test-request")
    public ResponseEntity<String> testPostRequest() {
        return ResponseEntity.ok("POST request successful");
    }
}
