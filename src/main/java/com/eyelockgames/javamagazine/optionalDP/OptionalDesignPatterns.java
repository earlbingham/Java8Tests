package com.eyelockgames.javamagazine;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;

public class OptionalDesignPatterns {

    enum TYPE {SAVINGS, CREDIT, DEBIT;}

    private String name;
    private Optional<TYPE> type = Optional.of(TYPE.SAVINGS);
    private Double balance = 0.0;

    public OptionalDesignPatterns(String name, Double balance) {
        this.name = Objects.requireNonNull(name, () -> "Account Name cannot be null.");
        this.balance = balance;
    }

    public OptionalDesignPatterns(String name, Double balance, Optional<TYPE> type) {
        this(name, balance);
        this.type = type;
    }

    public void setType(Optional<TYPE> type) {
        this.type = type;
    }

    public Optional<TYPE> getType() {
        return type;
    }

    public Optional<Double> getBalance() {
        return Optional.ofNullable(balance);
    }

    private String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        OptionalDesignPatterns acc = new OptionalDesignPatterns("Euro Account", null);

        acc.getBalance().ifPresent(System.out::println);
        acc.getType().ifPresent(System.out::println);
        System.out.println(acc.getName());
    }

}

