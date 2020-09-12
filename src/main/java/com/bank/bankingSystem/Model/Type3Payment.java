package com.bank.bankingSystem.Model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Type3Payment extends  Payment{

    @NotBlank(message = "Please enter 'Bank BIC code'")
    private String bankBicCode;

    private String type = "Type3";

    public String getBankBicCode() {
        return bankBicCode;
    }

    public void setBankBicCode(String bankBicCode) {
        this.bankBicCode = bankBicCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
