package kata.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountWithMoneyTest {

    @Test
    public void printListOfStatements() {

    }

    @Test
    public void depositShouldWorksCorrectly() {
        Money zeroMoney = new Money();
        zeroMoney.setMoneyAmount(0);
        Money depositMoney = new Money();
        depositMoney.setMoneyAmount(100);

        AccountWithMoney accountWithMoney = new AccountWithMoney();
        accountWithMoney.deposit(depositMoney);

        assertEquals(accountWithMoney.getMoneyStored().getMoneyAmount(), depositMoney.getMoneyAmount());
    }

    @Test
    public void kataExample() {
        Money fiveHundredMoney = new Money();
        fiveHundredMoney.setMoneyAmount(500);
        Money hundredMoney = new Money();
        hundredMoney.setMoneyAmount(100);

        AccountWithMoney accountWithMoney = new AccountWithMoney();
        accountWithMoney.deposit(fiveHundredMoney);
        accountWithMoney.withDraw(hundredMoney);
        accountWithMoney.printListOfStatements();
//        assertEquals(accountWithMoney.getMoneyStored().getAmount(), hundredMoney.getAmount());
    }

    @Test
    public void withDrawShouldWordCorrectly() {
        Money money = new Money();
        money.setMoneyAmount(100);
        Money otherMoney = new Money();
        otherMoney.setMoneyAmount(100);

        AccountWithMoney accountWithMoney = new AccountWithMoney();
        accountWithMoney.deposit(money);

        accountWithMoney.withDraw(otherMoney);

        Money expectedMoney = new Money();
        expectedMoney.setMoneyAmount(0);

        assertEquals(accountWithMoney.getMoneyStored().getMoneyAmount(), expectedMoney.getMoneyAmount());
    }

    @Test
    public void withDrawWithoutAvailableResourceShouldNotBeDone() {
        Money money = new Money();
        money.setMoneyAmount(100);
        Money otherMoney = new Money();
        otherMoney.setMoneyAmount(200);

        AccountWithMoney accountWithMoney = new AccountWithMoney();
        accountWithMoney.deposit(money);

        accountWithMoney.withDraw(otherMoney);

        Money expectedMoney = new Money();
        expectedMoney.setMoneyAmount(100);

        assertEquals(accountWithMoney.getMoneyStored().getMoneyAmount(), expectedMoney.getMoneyAmount());
    }

    @Test
    public void getMoneyStoredCorrectly() {
        Money money = new Money();
        money.setMoneyAmount(100);

        AccountWithMoney accountWithMoney = new AccountWithMoney();
        accountWithMoney.deposit(money);

        assertEquals(accountWithMoney.getMoneyStored().getMoneyAmount(), money.getMoneyAmount());
    }

}