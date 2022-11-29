package ru.guluev.moneytransferservice.model;

public class TransferManager {
    private String cardFromNumber;
    private String cardFromValidTill;
    private String cardFromCVV;
    private String cardToNumber;
    private AmountManager amount;

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
        return String.format("money transfer from card : %s to card %s in the amount of %d, commission %d"
                , cardFromNumber, cardToNumber, amount.getValue(), amount.getValue() / 100);
    }
}
