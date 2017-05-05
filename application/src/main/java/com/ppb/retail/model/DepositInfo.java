package com.ppb.retail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ToderoiuC on 5/4/2017.
 */
@Entity
@Table(name="deposit_info", schema = "retail")
public class DepositInfo {
    @Id
    @GeneratedValue
    @Column
    private String cardId;

    @Column
    private String cardNumber;

    @Column
    private String pin;

    @Column
    private Long lastDepositAmount;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Long getLastDepositAmount() {
        return lastDepositAmount;
    }

    public void setLastDepositAmount(Long lastDepositAmount) {
        this.lastDepositAmount = lastDepositAmount;
    }
}
