package com.pawman.b2bmanagement.model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
public class Contract {
    @Id
    @Column(name = "contract_number", nullable = false)
    private String contractNumber;

    @ManyToOne(optional = false)
    @JoinColumn(name = "seller_id", nullable = false)
    private Company seller;

    @ManyToOne(optional = false)
    @JoinColumn(name = "buyer_id", nullable = false)
    private Company buyer;

    @Column(name = "hourly_rate", nullable = false)
    private Double hourlyRate;

    @Column(name = "vat", nullable = false)
    private Integer vat;

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

    public Integer getVat() {
        return vat;
    }

    public void setVat(Integer vat) {
        this.vat = vat;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Company getBuyer() {
        return buyer;
    }

    public void setBuyer(Company buyer) {
        this.buyer = buyer;
    }

    public Company getSeller() {
        return seller;
    }

    public void setSeller(Company seller) {
        this.seller = seller;
    }

}
