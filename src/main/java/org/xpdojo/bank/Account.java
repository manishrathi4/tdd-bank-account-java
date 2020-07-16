package org.xpdojo.bank;

public class Account {
    private long balance = 0;

    public long balance() {
        return balance;
    }

    public long deposit (long amount) throws InvalidAmountDepositedException {
        if (amount <= 0)
            throw new InvalidAmountDepositedException();

        balance += amount;
        return balance;
    }

    public long withdraw(long amount) throws InsufficientBalanceException{
        if (balance < amount)
            throw new InsufficientBalanceException();

        balance -= amount;
        return balance;
    }
}

class InsufficientBalanceException extends Exception {
}

class InvalidAmountDepositedException extends Exception {
}
