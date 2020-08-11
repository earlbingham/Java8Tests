package com.eyelockgames.designpatterns.creational.builder;

import com.eyelockgames.designpatterns.creational.builder.BankAccountBuilder;

public class BankAccountProcessor {
    public static void main(String[] args) {
        BankAccountBuilder account = new BankAccountBuilder.Builder(1234L)
                .withOwner("Marge")
                .atBranch("Springfield")
                .openingBalance(100)
                .atRate(2.5)
                .build();
        BankAccountBuilder anotherAccount = new BankAccountBuilder.Builder(4567L)
                .withOwner("Homer")
                .atBranch("Springfield")
                .openingBalance(100)
                .atRate(2.5)
                .build();
        System.out.println("account: " + account.getAccountNumber() );
    }
}
