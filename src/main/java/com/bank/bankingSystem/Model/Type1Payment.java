package com.bank.bankingSystem.Model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Type1Payment extends Payment {

    @NotBlank(message = "Please enter 'Details'")
    private String details;

    private String type = "Type1";

    public String getDetails() {
        return details;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
