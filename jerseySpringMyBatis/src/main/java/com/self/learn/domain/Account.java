package com.self.learn.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class Account {
    private Integer id;
    private String cardId;
    private BigDecimal balance;
    private LocalDateTime date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
