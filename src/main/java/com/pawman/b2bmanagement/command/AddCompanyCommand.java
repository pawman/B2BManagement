package com.pawman.b2bmanagement.command;

import com.pawman.b2bmanagement.model.Bank;
import com.pawman.b2bmanagement.model.User;

public class AddCompanyCommand {

    private String companyName;

    private String regon;

    private User user;

    private Bank bank;

    public AddCompanyCommand() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public User getPerson() {
        return user;
    }

    public void setPerson(User user) {
        this.user = user;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
