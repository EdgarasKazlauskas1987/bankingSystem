package com.bank.bankingSystem.Model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Type1Payment extends Payment {

    @NotBlank(message = "Please enter 'Details'")
    private String details;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    // Create constructor
}
