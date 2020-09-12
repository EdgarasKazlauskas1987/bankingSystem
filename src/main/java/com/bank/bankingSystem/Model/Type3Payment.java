package com.bank.bankingSystem.Model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Type3Payment extends  Payment{

    @NotBlank(message = "Please enter 'Bank BIC code'")
    private String bankBicCode;

    public String getBankBicCode() {
        return bankBicCode;
    }

    public void setBankBicCode(String bankBicCode) {
        this.bankBicCode = bankBicCode;
    }
}
