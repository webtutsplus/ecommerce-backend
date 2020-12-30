package com.webtutsplus.ecommerce.controller;


import com.webtutsplus.ecommerce.dto.*;
import com.webtutsplus.ecommerce.dto.userDTOs.SignInDto;
import com.webtutsplus.ecommerce.dto.userDTOs.SignInResponseDto;
import com.webtutsplus.ecommerce.dto.userDTOs.SignupDto;
import com.webtutsplus.ecommerce.dto.userDTOs.UserCreateDto;
import com.webtutsplus.ecommerce.exceptions.AuthenticationFailException;
import com.webtutsplus.ecommerce.exceptions.CustomException;
import com.webtutsplus.ecommerce.model.User;
import com.webtutsplus.ecommerce.repository.UserRepository;
import com.webtutsplus.ecommerce.service.AuthenticationService;
import com.webtutsplus.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {
    @Autowired UserRepository userRepository;
    @Autowired AuthenticationService authenticationService;
    @Autowired UserService userService;

    // TODO: Find out where the token comes from.
    /**
     *
     * @param token
     * @return
     * @throws AuthenticationFailException
     */
    @GetMapping("/all")
    public List<User> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        return userRepository.findAll();
    }

    // TODO: Find out why we aren't using ApiResponse.
    /**
     * Handles POST requests to /api/user/signup. This function is responsible for signing new users up.
     * @param signupDto Signup Data Transfer Object containing the user data.
     * @return ResponseDto
     * @throws CustomException Exception gets thrown from the function that gets called by this function.
     */
    @PostMapping("/signup")
    public ResponseDto signUp(@RequestBody SignupDto signupDto) throws CustomException {
        return userService.signUp(signupDto);
    }

    //TODO token should be updated
    /**
     * Function used to sign in the user
     * @param signInDto
     * @return
     * @throws CustomException
     */
    @PostMapping("/signIn")
    public SignInResponseDto signIn(@RequestBody SignInDto signInDto) throws CustomException {
        return userService.signIn(signInDto);
    }

//    @PostMapping("/updateUser")
//    public ResponseDto updateUser(@RequestParam("token") String token, @RequestBody UserUpdateDto userUpdateDto) {
//        authenticationService.authenticate(token);
//        return userService.updateUser(token, userUpdateDto);
//    }

//    @PostMapping("/createUser")
//    public ResponseDto updateUser(@RequestParam("token") String token, @RequestBody UserCreateDto userCreateDto)
//            throws CustomException, AuthenticationFailException {
//        authenticationService.authenticate(token);
//        return userService.createUser(token, userCreateDto);
//    }
}
