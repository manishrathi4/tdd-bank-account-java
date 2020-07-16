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
    public void depositAmountToIncreaseBalance() {
        Account account = new Account();
        account.deposit(10);
        assertThat(account.balance()).isEqualTo(10);
    }

    @Test
    public void depositMultipleAmountToIncreaseBalance() {
        Account account = new Account();
        account.deposit(10);
        account.deposit(20);
        assertThat(account.balance()).isEqualTo(30);
    }

    @Test
    public void withdrawAmountThatIsLessThanBalance() throws InsufficientBalanceException {
     Account account = new Account();
     account.deposit(100);
     account.withdraw(10);
     assertThat(account.balance()).isEqualTo(90);
    }

    @Test
    public void withdrawMultipleAmountsThatIsLessThanBalance() throws InsufficientBalanceException {
        Account account = new Account();
        account.deposit(100);
        account.withdraw(10);
        account.withdraw(20);
        assertThat(account.balance()).isEqualTo(70);
    }

    @Test
    public void withdrawAmountThatIsGreaterThanBalance() {
        Account account = new Account();
        account.deposit(100);
        assertThatExceptionOfType(InsufficientBalanceException.class)
                .isThrownBy(() -> account.withdraw(120));
    }
}
