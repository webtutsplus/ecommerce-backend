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

    /**
     * Handles GET requests to /api/user/all. Used to get a list of all the users.
     * @param token The user's login token.
     * @return A list of all known users.
     * @throws AuthenticationFailException
     */
    @GetMapping("/all")
    public List<User> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        return userRepository.findAll();
    }

    /**
     * Handles POST requests to /api/user/signup. Used to sign a new user up.
     * @param signupDto The signupDto from the front-end.
     * @return A responseDto.
     * @throws CustomException
     */
    @PostMapping("/signup")
    public ResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
        return userService.signUp(signupDto);
    }

    //TODO token should be updated

    /**
     * Handles POST requests to /api/user/signIn. Used to sign in a user.
     * @param signInDto A singInDto from the front-end.
     * @return A SignInResponseDto.
     * @throws CustomException
     */
    @PostMapping("/signIn")
    public SignInResponseDto Signup(@RequestBody SignInDto signInDto) throws CustomException {
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
