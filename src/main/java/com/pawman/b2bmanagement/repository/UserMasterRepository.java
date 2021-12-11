package com.pawman.b2bmanagement.repository;

import com.pawman.b2bmanagement.model.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMasterRepository extends JpaRepository<UserMaster, Long> {
}