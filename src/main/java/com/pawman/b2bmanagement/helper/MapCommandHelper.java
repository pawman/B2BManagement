package com.pawman.b2bmanagement.helper;

import com.pawman.b2bmanagement.command.AddCompanyCommand;
import com.pawman.b2bmanagement.model.Address;
import com.pawman.b2bmanagement.model.Bank;
import com.pawman.b2bmanagement.model.Company;
import com.pawman.b2bmanagement.model.User;
import org.springframework.stereotype.Component;

@Component
public class MapCommandHelper {

    public Company mapAddCompanyCommandToCompany(AddCompanyCommand companyCommand, User user, Bank bank) {
        return new Company(
                companyCommand.getRegon(),
                companyCommand.getCompanyName(),
                bank,
                user
        );
    }

    public User mapAddCompanyCommandToPerson(AddCompanyCommand companyCommand, Address address) {
        return new User(
                companyCommand.getPerson().getPesel(),
                companyCommand.getPerson().getFirstName(),
                companyCommand.getPerson().getLastName(),
                companyCommand.getPerson().getNip(),
                address
        );
    }

    public Address mapAddCompanyCommandToAddress(AddCompanyCommand companyCommand) {
        return new Address(companyCommand.getPerson().getAddress());
    }

    public Bank mapAddCompanyCommandToBank(AddCompanyCommand companyCommand) {
        return new Bank(companyCommand.getBank());
    }
}
