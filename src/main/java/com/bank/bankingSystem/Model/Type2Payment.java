package com.bank.bankingSystem.Model;

import javax.persistence.Entity;

@Entity
public class Type2Payment extends Payment {

    private String details;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
