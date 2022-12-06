package ru.guluev.moneytransferservice.beans;

import ru.guluev.moneytransferservice.annotation.TransferAmount;

public class
AmountManager {
    @TransferAmount
    private String value;
    private String currency;

    public AmountManager(String value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
