package com.pawman.b2bmanagement.repository;

import com.pawman.b2bmanagement.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}