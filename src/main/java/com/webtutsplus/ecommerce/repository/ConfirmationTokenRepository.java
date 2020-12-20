package com.webtutsplus.ecommerce.repository;


import com.webtutsplus.ecommerce.model.AuthenticationToken;
import com.webtutsplus.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<AuthenticationToken, Integer> {
    AuthenticationToken findConfirmationTokenByUser(User user);
    AuthenticationToken findConfirmationTokenByConfirmationToken(String token);
}
