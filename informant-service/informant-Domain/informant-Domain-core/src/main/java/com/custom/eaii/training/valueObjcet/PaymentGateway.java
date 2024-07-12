package com.custom.eaii.training.valueObjcet;

import java.util.Objects;
import java.util.UUID;

public class PaymentGateway {
//    BANK_NAME, ACCOUNT_NUMBER

    private final UUID id;
    private final String  BankName;

    private final int AccountNumber;

    public PaymentGateway(UUID id, String bankName, int accountNumber) {
        this.id = id;
        BankName = bankName;
        AccountNumber = accountNumber;
    }

    public UUID getId() {
        return id;
    }

    public String getBankName() {
        return BankName;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentGateway that)) return false;
        return AccountNumber == that.AccountNumber && Objects.equals(id, that.id) && Objects.equals(BankName, that.BankName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(BankName, AccountNumber);
    }
}
