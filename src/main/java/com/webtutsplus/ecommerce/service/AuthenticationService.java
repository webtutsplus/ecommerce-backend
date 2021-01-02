package com.webtutsplus.ecommerce.service;


import com.webtutsplus.ecommerce.config.MessageStrings;
import com.webtutsplus.ecommerce.exceptions.AuthenticationFailException;
import com.webtutsplus.ecommerce.model.AuthenticationToken;
import com.webtutsplus.ecommerce.model.User;
import com.webtutsplus.ecommerce.repository.ConfirmationTokenRepository;
import com.webtutsplus.ecommerce.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired ConfirmationTokenRepository repository;

    /**
     * Used to save the confirmation token to the database.
     * @param authenticationToken The authentication token given to the user.
     */
    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
        repository.save(authenticationToken);
    }

    /**
     * Used to get the authentication token for a specific user.
     * @param user The user which you want to check against.
     * @return The user's authentication token.
     */
    public AuthenticationToken getToken(User user) {
        return repository.findConfirmationTokenByUser(user);
    }

    /**
     * Used to get the user to which the token belongs.
     * @param token The authentication token you want to check
     * @return The user to which the authentication token belongs to.
     */
    public User getUser(String token) {
        AuthenticationToken authenticationToken = repository.findConfirmationTokenByConfirmationToken(token);
        if (Helper.notNull(authenticationToken)) {
            if (Helper.notNull(authenticationToken.getUser())) {
                return authenticationToken.getUser();
            }
        }
        return null;
    }

    /**
     * Used to check whether an authentication token is valid and/or present.
     * @param token The authentication token.
     * @throws AuthenticationFailException
     */
    public void authenticate(String token) throws AuthenticationFailException {
        if (!Helper.notNull(token)) {
            throw new AuthenticationFailException(MessageStrings.AUTH_TOKEN_NOT_PRESENT);
        }

        if (!Helper.notNull(getUser(token))) {
            throw new AuthenticationFailException(MessageStrings.AUTH_TOKEN_NOT_VALID);
        }
    }
}
