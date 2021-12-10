package com.pawman.b2bmanagement.service;

import com.pawman.b2bmanagement.model.*;
import com.pawman.b2bmanagement.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SaveDataService {

    private final AddressRepository addressRepository;
    private final BankRepository bankRepository;
    private final CompanyRepository companyRepository;
    private final ContractRepository contractRepository;
    private final UserRepository userRepository;
    private final UserMasterRepository userMasterRepository;
    private final InvoiceRepository invoiceRepository;

    public SaveDataService(AddressRepository addressRepository, BankRepository bankRepository, CompanyRepository companyRepository, ContractRepository contractRepository, UserRepository userRepository, UserMasterRepository userMasterRepository, InvoiceRepository invoiceRepository) {
        this.addressRepository = addressRepository;
        this.bankRepository = bankRepository;
        this.companyRepository = companyRepository;
        this.contractRepository = contractRepository;
        this.userRepository = userRepository;
        this.userMasterRepository = userMasterRepository;
        this.invoiceRepository = invoiceRepository;
    }

    public Bank saveBank(Bank bank) {
        return bankRepository.save(bank);
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public UserMaster saveUserMaster(UserMaster user) {
        return userMasterRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void disableUser(Long id) {
        User user = userRepository.getById(id);

        boolean active = user.isActive();
        if (!active) {
            user.setDisabledFrom(null);
        } else {
            user.setDisabledFrom(LocalDateTime.now());
        }
        user.setActive(!active);

        userRepository.save(user);
    }

    public void saveCompany(Company company) {
        companyRepository.save(company);
    }

    public void disableCompany(Long id) {
        Company company = companyRepository.getById(id);

        boolean active = company.isActive();
        if (!active) {
            company.setDisabledFrom(null);
        } else {
            company.setDisabledFrom(LocalDateTime.now());
        }
        company.setActive(!active);

        companyRepository.save(company);
    }

    public void saveInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public void saveContract(Contract contract) {
        contractRepository.save(contract);
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    public void disableContract(String contractNumber) {
        Optional<Contract> contract = contractRepository.findById(contractNumber);
        if (contract.isPresent()) {
            boolean active = contract.get().isActive();
            if (!active) {
                contract.get().setDisabledFrom(null);
            } else {
                contract.get().setDisabledFrom(LocalDateTime.now());
            }
            contract.get().setActive(!active);

            contractRepository.save(contract.get());
        }
    }
}
