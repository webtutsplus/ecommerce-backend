package com.webtutsplus.ecommerce.service;


import com.webtutsplus.ecommerce.config.MessageStrings;
import com.webtutsplus.ecommerce.dto.*;
import com.webtutsplus.ecommerce.dto.userDTOs.SignInDto;
import com.webtutsplus.ecommerce.dto.userDTOs.SignInResponseDto;
import com.webtutsplus.ecommerce.dto.userDTOs.SignupDto;
import com.webtutsplus.ecommerce.dto.userDTOs.UserCreateDto;
import com.webtutsplus.ecommerce.enums.ResponseStatus;
import com.webtutsplus.ecommerce.enums.Role;
import com.webtutsplus.ecommerce.exceptions.AuthenticationFailException;
import com.webtutsplus.ecommerce.exceptions.CustomException;
import com.webtutsplus.ecommerce.model.AuthenticationToken;
import com.webtutsplus.ecommerce.model.User;
import com.webtutsplus.ecommerce.repository.UserRepository;
import com.webtutsplus.ecommerce.utils.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.webtutsplus.ecommerce.config.MessageStrings.USER_CREATED;


@Service
public class UserService {
    @Autowired UserRepository userRepository;
    @Autowired AuthenticationService authenticationService;
    Logger logger = LoggerFactory.getLogger(UserService.class);

    /**
     * Used to sign a new user up.
     * @param signupDto The sign up data transfer object containing the new user information.
     * @return A custom response data trasnfer object.
     * @throws CustomException
     */
    public ResponseDto signUp(SignupDto signupDto)  throws CustomException {
        // Check to see if the current email address has already been registered.
        if (Helper.notNull(userRepository.findByEmail(signupDto.getEmail()))) {
            // If the email address has been registered then throw an exception.
            throw new CustomException("User already exists");
        }
        // first encrypt the password
        String encryptedPassword = signupDto.getPassword();
        try {
            encryptedPassword = hashPassword(signupDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("hashing password failed {}", e.getMessage());
        }


        User user = new User(signupDto.getFirstName(), signupDto.getLastName(), signupDto.getEmail(), Role.user, encryptedPassword );

        User createdUser;
        try {
            // save the User
            createdUser = userRepository.save(user);
            // generate token for user
            final AuthenticationToken authenticationToken = new AuthenticationToken(createdUser);
            // save token in database
            authenticationService.saveConfirmationToken(authenticationToken);
            // success in creating
            return new ResponseDto(ResponseStatus.success.toString(), USER_CREATED);
        } catch (Exception e) {
            // handle signup error
            throw new CustomException(e.getMessage());
        }
    }

    /**
     * Used to sign the user into their account.
     * @param signInDto The sign in data transfer object from the front-end.
     * @return A custom response data transfer object.
     * @throws CustomException
     */
    public SignInResponseDto signIn(SignInDto signInDto) throws CustomException {
        // first find User by email
        User user = userRepository.findByEmail(signInDto.getEmail());
        if(!Helper.notNull(user)){
            throw  new AuthenticationFailException("user not present");
        }
        try {
            // check if password is right
            if (!user.getPassword().equals(hashPassword(signInDto.getPassword()))){
                // passowrd doesnot match
                throw  new AuthenticationFailException(MessageStrings.WRONG_PASSWORD);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("hashing password failed {}", e.getMessage());
            throw new CustomException(e.getMessage());
        }

        AuthenticationToken token = authenticationService.getToken(user);

        if(!Helper.notNull(token)) {
            // token not present
            throw new CustomException("token not present");
        }

        return new SignInResponseDto ("success", token.getConfirmationToken());
    }

    /**
     * Function used to create a password hash.
     * @param password The user's password.
     * @return A hashed password string.
     * @throws NoSuchAlgorithmException
     */
    String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return myHash;
    }

    /**
     * Used to create a new user with a special role.
     * @param token The token of an admin user.
     * @param userCreateDto The new user information.
     * @return A specialized response data transfer object.
     * @throws CustomException
     * @throws AuthenticationFailException
     */
    public ResponseDto createUser(String token, UserCreateDto userCreateDto) throws CustomException, AuthenticationFailException {
        User creatingUser = authenticationService.getUser(token);
        if (!canCrudUser(creatingUser.getRole())) {
            // user can't create new user
            throw  new AuthenticationFailException(MessageStrings.USER_NOT_PERMITTED);
        }
        String encryptedPassword = userCreateDto.getPassword();
        try {
            encryptedPassword = hashPassword(userCreateDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("hashing password failed {}", e.getMessage());
        }

        User user = new User(userCreateDto.getFirstName(), userCreateDto.getLastName(), userCreateDto.getEmail(), userCreateDto.getRole(), encryptedPassword );
        User createdUser;
        try {
            createdUser = userRepository.save(user);
            final AuthenticationToken authenticationToken = new AuthenticationToken(createdUser);
            authenticationService.saveConfirmationToken(authenticationToken);
            return new ResponseDto(ResponseStatus.success.toString(), USER_CREATED);
        } catch (Exception e) {
            // handle user creation fail error
            throw new CustomException(e.getMessage());
        }

    }

    /**
     * Used to check if the user has a high enough permission role.
     * @param role The role of the user.
     * @return A boolean.
     */
    boolean canCrudUser(Role role) {
        if (role == Role.admin || role == Role.manager) {
            return true;
        }
        return false;
    }

    /**
     * Used to check if the user has a high enough permission role.
     * @param userUpdating The admin or manager user.
     * @param userIdBeingUpdated The user being updated's ID.
     * @return A boolean.
     */
    boolean canCrudUser(User userUpdating, Integer userIdBeingUpdated) {
        Role role = userUpdating.getRole();
        // admin and manager can crud any user
        if (role == Role.admin || role == Role.manager) {
            return true;
        }
        // user can update his own record, but not his role
        if (role == Role.user && userUpdating.getId() == userIdBeingUpdated) {
            return true;
        }
        return false;
    }
}
