package com.bank.bankingSystem.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity //maybe remove this?
public abstract class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Please enter 'amount'")
    private double amount;

    @NotBlank(message = "Please enter 'currency'")
    private String currency;

    @NotBlank(message = "Please enter 'Debtor IBAN'")
    private String debtorIban;

    @NotBlank(message = "Please enter 'Creditor IBAN'")
    private String creditorIban;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDebtorIban() {
        return debtorIban;
    }

    public void setDebtorIban(String debtorIban) {
        this.debtorIban = debtorIban;
    }

    public String getCreditorIban() {
        return creditorIban;
    }

    public void setCreditorIban(String creditorIban) {
        this.creditorIban = creditorIban;
    }

        /*
    @NotBlank(message = "Currency is mandatory")
    enum Currency {
        EUR,
        USD
    }
    */
}

