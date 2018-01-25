package org.suggs.katas.bankaccount;

import lombok.EqualsAndHashCode;

import static org.suggs.katas.bankaccount.Money.aMonetaryAmountOf;

@EqualsAndHashCode
public class Account {
    private Money balance;

    public static Account anAccountWithABalanceOf(Money amount) {
        return new Account(amount);
    }

    public static Account anEmptyAccount() {
        return new Account(aMonetaryAmountOf(0.0d));
    }

    private Account(Money anAmount) {
        this.balance = anAmount;
    }

    public void deposit(Money anAmount) {
        balance = balance.add(anAmount);
    }

    public void withdraw(Money anAmount) {
        balance = balance.less(anAmount);
    }

    public void transfer(Money money, Account destinationAccount) {
        destinationAccount.deposit(money);
        this.withdraw(money);
    }
}