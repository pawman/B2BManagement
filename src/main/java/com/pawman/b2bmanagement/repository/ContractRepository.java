package com.pawman.b2bmanagement.repository;

import com.pawman.b2bmanagement.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, String> {
}