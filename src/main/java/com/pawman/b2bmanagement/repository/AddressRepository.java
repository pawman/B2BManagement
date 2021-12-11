package com.pawman.b2bmanagement.repository;

import com.pawman.b2bmanagement.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}