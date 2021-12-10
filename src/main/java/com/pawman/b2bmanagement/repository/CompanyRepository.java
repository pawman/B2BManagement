package com.pawman.b2bmanagement.repository;

import com.pawman.b2bmanagement.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}