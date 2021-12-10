package com.pawman.b2bmanagement.repository;

import com.pawman.b2bmanagement.model.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserMasterRepository extends JpaRepository<UserMaster, Long> {
}