package org.xpdojo.bank;

public class Account {
    private long balance = 0;

    public long balance() {
        return balance;
    }

    public long deposit (long amount) {
        balance += amount;
        return balance;
    }

    public long withdraw(long amount) {
        balance -= amount;
        return balance;
    }
}
