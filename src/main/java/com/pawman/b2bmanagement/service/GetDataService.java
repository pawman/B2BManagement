package com.pawman.b2bmanagement.service;

import com.pawman.b2bmanagement.model.Company;
import com.pawman.b2bmanagement.model.Contract;
import com.pawman.b2bmanagement.model.Invoice;
import com.pawman.b2bmanagement.model.User;
import com.pawman.b2bmanagement.model.UserMaster;
import com.pawman.b2bmanagement.repository.AddressRepository;
import com.pawman.b2bmanagement.repository.BankRepository;
import com.pawman.b2bmanagement.repository.CompanyRepository;
import com.pawman.b2bmanagement.repository.ContractRepository;
import com.pawman.b2bmanagement.repository.InvoiceRepository;
import com.pawman.b2bmanagement.repository.UserMasterRepository;
import com.pawman.b2bmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetDataService {

    private final AddressRepository addressRepository;
    private final BankRepository bankRepository;
    private final CompanyRepository companyRepository;
    private final ContractRepository contractRepository;
    private final UserRepository userRepository;
    private final UserMasterRepository userMasterRepository;
    private final InvoiceRepository invoiceRepository;

    public GetDataService(AddressRepository addressRepository, BankRepository bankRepository, CompanyRepository companyRepository, ContractRepository contractRepository, UserRepository userRepository, UserMasterRepository userMasterRepository, InvoiceRepository invoiceRepository) {
        this.addressRepository = addressRepository;
        this.bankRepository = bankRepository;
        this.companyRepository = companyRepository;
        this.contractRepository = contractRepository;
        this.userRepository = userRepository;
        this.userMasterRepository = userMasterRepository;
        this.invoiceRepository = invoiceRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<User> getActiveUsers() {
        return userRepository.findActiveUser();
    }

    public List<User> getUsersByUserMaster(UserMaster userMaster) {
        return userRepository.findByUserMaster(userMaster);
    }

    public List<UserMaster> getUserMasters() {
        return userMasterRepository.findAll();
    }

    public UserMaster getUserMasterById(Long id) {
        return userMasterRepository.getById(id);
    }

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompaniesById(Long id) {
        return companyRepository.findById(id);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<Invoice> invoices() {
        return invoiceRepository.findAll();
    }

    public List<Contract> contracts() {
        return contractRepository.findAll();
    }

    public Optional<Contract> getContractById(String contractNumber) {
        return contractRepository.findById(contractNumber);
    }

}
