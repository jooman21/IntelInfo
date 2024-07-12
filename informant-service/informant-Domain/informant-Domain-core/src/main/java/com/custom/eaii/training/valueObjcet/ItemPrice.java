package com.custom.eaii.training.valueObjcet;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class ItemPrice {
    private UUID id;
    private final BigDecimal amount;

    private final String currency;

    public ItemPrice(UUID id, BigDecimal amount, String currency) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemPrice itemPrice)) return false;
        return Objects.equals(amount, itemPrice.amount) && Objects.equals(currency, itemPrice.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }
}
