package com.pawman.b2bmanagement.repository;

import com.pawman.b2bmanagement.model.User;
import com.pawman.b2bmanagement.model.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    List<User> findByUserMaster(UserMaster userMaster);

    @Query("SELECT u FROM User u WHERE u.active = true")
    List<User> findActiveUser();


}