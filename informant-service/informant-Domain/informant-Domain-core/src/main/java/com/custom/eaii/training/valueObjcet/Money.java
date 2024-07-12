package com.custom.eaii.training.valueObjcet;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public class Money {

    private final BigDecimal amount;

    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
    }

    public BigDecimal getAmount(){
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money money)) return false;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
