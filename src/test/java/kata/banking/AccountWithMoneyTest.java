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
        zeroMoney.setAmount(0);
        Money depositMoney = new Money();
        depositMoney.setAmount(100);

        AccountWithMoney accountWithMoney = new AccountWithMoney();
        accountWithMoney.deposit(depositMoney);

        assertEquals(accountWithMoney.getMoneyStored().getAmount(), depositMoney.getAmount());
    }

    @Test
    public void kataExample() {
        Money fiveHundredMoney = new Money();
        fiveHundredMoney.setAmount(500);
        Money hundredMoney = new Money();
        hundredMoney.setAmount(100);

        AccountWithMoney accountWithMoney = new AccountWithMoney();
        accountWithMoney.deposit(fiveHundredMoney);
        accountWithMoney.withDraw(hundredMoney);
        accountWithMoney.printListOfStatements();
//        assertEquals(accountWithMoney.getMoneyStored().getAmount(), hundredMoney.getAmount());
    }

    @Test
    public void withDrawShouldWordCorrectly() {
        Money money = new Money();
        money.setAmount(100);
        Money otherMoney = new Money();
        otherMoney.setAmount(100);

        AccountWithMoney accountWithMoney = new AccountWithMoney();
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

        AccountWithMoney accountWithMoney = new AccountWithMoney();
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

        AccountWithMoney accountWithMoney = new AccountWithMoney();
        accountWithMoney.deposit(money);


        assertEquals(accountWithMoney.getMoneyStored().getAmount(), money.getAmount());
    }

}