package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AccountTest {

    @Test
    public void newAccountShouldHaveZeroBalance() {
        Account account = new Account();
        assertThat(account.balance()).isEqualTo(0);
    }

    @Test
    public void depositAmountToIncreaseBalance() throws InvalidAmountDepositedException {
        Account account = new Account();
        account.deposit(10);
        assertThat(account.balance()).isEqualTo(10);
    }

    @Test
    public void depositMultipleAmountToIncreaseBalance() throws InvalidAmountDepositedException {
        Account account = new Account();
        account.deposit(10);
        account.deposit(20);
        assertThat(account.balance()).isEqualTo(30);
    }

    @Test
    public void depositingNegativeAmountShouldNotBeAllowed() {
        Account account = new Account();
        assertThatExceptionOfType(InvalidAmountDepositedException.class)
                .isThrownBy(() -> account.deposit(-100));
    }

    @Test
    public void depositingZeroAmountShouldNotBeAllowed() {
        Account account = new Account();
        assertThatExceptionOfType(InvalidAmountDepositedException.class)
                .isThrownBy(() -> account.deposit(0));
    }

    @Test
    public void withdrawAmountFromNewAccountShouldNotBeAllowed() throws InsufficientBalanceException {
        Account account = new Account();
        assertThatExceptionOfType(InsufficientBalanceException.class)
                .isThrownBy(() -> account.withdraw(100));
    }

    @Test
    public void withdrawAmountThatIsLessThanBalance() throws InsufficientBalanceException, InvalidAmountDepositedException {
     Account account = new Account();
     account.deposit(100);
     account.withdraw(10);
     assertThat(account.balance()).isEqualTo(90);
    }

    @Test
    public void withdrawMultipleAmountsThatIsLessThanBalance() throws InsufficientBalanceException, InvalidAmountDepositedException {
        Account account = new Account();
        account.deposit(100);
        account.withdraw(10);
        account.withdraw(20);
        assertThat(account.balance()).isEqualTo(70);
    }

    @Test
    public void withdrawAmountThatIsGreaterThanBalanceShouldNotBeAllowed() throws InvalidAmountDepositedException {
        Account account = new Account();
        account.deposit(100);
        assertThatExceptionOfType(InsufficientBalanceException.class)
                .isThrownBy(() -> account.withdraw(120));
    }
}
