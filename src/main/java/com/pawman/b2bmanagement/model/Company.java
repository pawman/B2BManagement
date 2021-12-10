package com.pawman.b2bmanagement.model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "regon", nullable = false)
    private String regon;

    @Column(name = "name", nullable = false, unique = true)
    private String name;


    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "bank_number", nullable = false)
    private Bank bank;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "disabled_from")
    private LocalDateTime disabledFrom;

    private boolean active = true;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getDisabledFrom() {
        return disabledFrom;
    }

    public void setDisabledFrom(LocalDateTime disabledFrom) {
        this.disabledFrom = disabledFrom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company(String regon, String name, Bank bank, User user) {
        this.regon = regon;
        this.name = name;
        this.bank = bank;
        this.user = user;
    }

    public Company() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }


}
