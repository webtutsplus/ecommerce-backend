package com.webtutsplus.ecommerce.repository;

import com.webtutsplus.ecommerce.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
