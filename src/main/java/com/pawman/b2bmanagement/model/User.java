package com.pawman.b2bmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
public class User extends Iterated {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "pesel", nullable = false, length = 12)
    private String pesel;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "nip", nullable = false)
    private String nip;

    @OneToOne(optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "disabled_from")
    private LocalDateTime disabledFrom;
    private boolean active = true;

    public User(User user) {
        this.pesel = user.pesel;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.nip = user.nip;
        this.address = user.address;
        this.disabledFrom = user.disabledFrom;
        this.active = user.active;
        this.userMaster = user.userMaster;
    }

    public User(String pesel, String firstName, String lastName, String nip, Address address, LocalDateTime disabledFrom, boolean active) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nip = nip;
        this.address = address;
        this.disabledFrom = disabledFrom;
        this.active = active;
    }


    public User() {
    }

    public User(String pesel, String firstName, String lastName, String nip, Address address) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nip = nip;
        this.address = address;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setUserMaster(UserMaster userMaster) {
        this.userMaster = userMaster;
    }

    public String getDisplayName() {
        return firstName + " " + lastName;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
