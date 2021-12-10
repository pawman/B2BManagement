package com.pawman.b2bmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bank {
    @Id
    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "name")
    private String name;

    public Bank() {
    }

    public Bank(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public Bank(Bank bank) {
        this.name = bank.getName();
        this.number = bank.getNumber();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
