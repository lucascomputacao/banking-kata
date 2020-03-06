package kata.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountWithMoneyTest {

    @Test
    public void printListOfStatements() {
    }

    @Test
    public void depositShouldWorksCorrectly() {
        Money zeroMoney = new Money(0);
        Money depositMoney = new Money(100);

        AccountWithMoney accountWithMoney = new AccountWithMoney();
        accountWithMoney.deposit(depositMoney);

        assertEquals(accountWithMoney.getMoneyStored().getMoneyAmount(), depositMoney.getMoneyAmount());
    }

    @Test
    public void kataExample() throws Exception {
        Money fiveHundredMoney = new Money(500);
        Money hundredMoney = new Money(100);

        AccountWithMoney accountWithMoney = new AccountWithMoney();
        accountWithMoney.deposit(fiveHundredMoney);
        accountWithMoney.withDraw(hundredMoney);
        accountWithMoney.printListOfStatements();
//        assertEquals(accountWithMoney.getMoneyStored().getAmount(), hundredMoney.getAmount());
    }

    @Test
    public void withDrawShouldWordCorrectly() throws Exception {
        Money money = new Money(100);
        Money otherMoney = new Money(100);

        AccountWithMoney accountWithMoney = new AccountWithMoney();
        accountWithMoney.deposit(money);

        accountWithMoney.withDraw(otherMoney);

        Money expectedMoney = new Money(0);

        assertEquals(accountWithMoney.getMoneyStored().getMoneyAmount(), expectedMoney.getMoneyAmount());
    }

    @Test
    public void withDrawWithoutAvailableResourceShouldNotBeDone() {
        Money money = new Money(100);
        Money otherMoney = new Money(200);


        AccountWithMoney accountWithMoney = new AccountWithMoney();
        accountWithMoney.deposit(money);

        Exception exception = assertThrows(Exception.class, () -> {
            accountWithMoney.withDraw(otherMoney);
        });
        String expectedMessage = "Insuficient amount in Account";

        Money expectedMoney = new Money(100);

        assertEquals(accountWithMoney.getMoneyStored().getMoneyAmount(), expectedMoney.getMoneyAmount());
        assertTrue(exception.getMessage().contains(expectedMessage));

    }

    @Test
    public void getMoneyStoredCorrectly() {
        Money money = new Money(100);

        AccountWithMoney accountWithMoney = new AccountWithMoney();
        accountWithMoney.deposit(money);

        assertEquals(accountWithMoney.getMoneyStored().getMoneyAmount(), money.getMoneyAmount());
    }

}