package com.bank.bankingSystem.Model;

import javax.persistence.Entity;

@Entity
public class Type2Payment extends Payment {

    private String details;

    private String type = "Type2";

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
