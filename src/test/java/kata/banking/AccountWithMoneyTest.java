package kata.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountWithMoneyTest {

    @Test
    public void printStatement() {

    }

    @Test
    public void depositShouldWorksCorrectly() {
        Money money = new Money();
        money.setAmount(100);

        AccountWithMoney accountWithMoney = new AccountWithMoney(money);
        accountWithMoney.deposit(money);

        assertEquals(accountWithMoney.getMoneyStored().getAmount(), money.getAmount());
    }

    @Test
    public void withDrawShouldWordCorrectly() {
        Money money = new Money();
        money.setAmount(100);
        Money otherMoney = new Money();
        otherMoney.setAmount(100);

        AccountWithMoney accountWithMoney = new AccountWithMoney(money);
        accountWithMoney.deposit(money);

        accountWithMoney.withDraw(otherMoney);

        Money expectedMoney = new Money();
        expectedMoney.setAmount(0);

        assertEquals(accountWithMoney.getMoneyStored().getAmount(), expectedMoney.getAmount());
    }

    @Test
    public void withDrawWithoutAvailableResourceShouldNotBeDone() {
        Money money = new Money();
        money.setAmount(100);
        Money otherMoney = new Money();
        otherMoney.setAmount(200);

        AccountWithMoney accountWithMoney = new AccountWithMoney(money);
        accountWithMoney.deposit(money);

        accountWithMoney.withDraw(otherMoney);

        Money expectedMoney = new Money();
        expectedMoney.setAmount(100);

        assertEquals(accountWithMoney.getMoneyStored().getAmount(), expectedMoney.getAmount());
    }

    @Test
    public void getMoneyStoredCorrectly() {
        Money money = new Money();
        money.setAmount(100);

        AccountWithMoney accountWithMoney = new AccountWithMoney(money);
        accountWithMoney.deposit(money);


        assertEquals(accountWithMoney.getMoneyStored(), money);
    }

}