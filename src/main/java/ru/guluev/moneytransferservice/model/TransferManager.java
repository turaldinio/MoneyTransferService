package ru.guluev.moneytransferservice.model;

import ru.guluev.moneytransferservice.annotation.CardCVV;
import ru.guluev.moneytransferservice.annotation.CardNumber;
import ru.guluev.moneytransferservice.beans.AmountManager;
import ru.guluev.moneytransferservice.annotation.CardFromValidTill;


public class TransferManager {
    @CardNumber
    private String cardFromNumber;

    @CardFromValidTill
    private String cardFromValidTill;

    @CardCVV
    private String cardFromCVV;

    @CardNumber()
    private String cardToNumber;

    private AmountManager amount;

    public TransferManager(String cardFromNumber, String cardFromValidTill, String cardFromCVV, String cardToNumber, AmountManager amount) {
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.cardToNumber = cardToNumber;
        this.amount = amount;
    }

    public String getCardFromNumber() {
        return cardFromNumber;
    }

    public void setCardFromNumber(String cardFromNumber) {
        this.cardFromNumber = cardFromNumber;
    }

    public String getCardFromValidTill() {
        return cardFromValidTill;
    }

    public void setCardFromValidTill(String cardFromValidTill) {
        this.cardFromValidTill = cardFromValidTill;
    }

    public String getCardFromCVV() {
        return cardFromCVV;
    }

    public void setCardFromCVV(String cardFromCVV) {
        this.cardFromCVV = cardFromCVV;
    }

    public String getCardToNumber() {
        return cardToNumber;
    }

    public void setCardToNumber(String cardToNumber) {
        this.cardToNumber = cardToNumber;
    }

    public AmountManager getAmount() {
        return amount;
    }

    public void setAmount(AmountManager amount) {
        this.amount = amount;
    }

    public void transferMoney(int amount) {

    }

    @Override
    public String toString() {
        return String.format("money transfer from card : %s to card %s in the amount of %s, commission %d"
                , cardFromNumber, cardToNumber, amount.getValue(), Integer.parseInt(amount.getValue()) / 100);
    }
}
