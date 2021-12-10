package com.pawman.b2bmanagement.repository;

import com.pawman.b2bmanagement.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, String> {
}