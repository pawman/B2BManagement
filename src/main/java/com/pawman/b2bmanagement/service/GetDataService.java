package com.pawman.b2bmanagement.service;

import com.pawman.b2bmanagement.model.*;
import com.pawman.b2bmanagement.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetDataService {

    private AddressRepository addressRepository;
    private BankRepository bankRepository;
    private CompanyRepository companyRepository;
    private ContractRepository contractRepository;
    private UserRepository userRepository;
    private UserMasterRepository userMasterRepository;
    private InvoiceRepository invoiceRepository;

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

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public List<Invoice> invoices(){
        return invoiceRepository.findAll();
    }

    public List<Contract> contracts(){
        return contractRepository.findAll();
    }

    public Optional<Contract> getContractById(String contractNumber){
        return contractRepository.findById(contractNumber);
    }

}
