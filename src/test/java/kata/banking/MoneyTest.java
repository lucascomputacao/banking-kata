package kata.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void addMoney() {
        Money money = new Money();
        Money otherMoney = new Money();

        money.setAmount(1);
        otherMoney.setAmount(2);
        Money moneyPlusOtherMoney = money.addMoney(otherMoney);

        assertEquals(moneyPlusOtherMoney.getAmount(), money.getAmount() + otherMoney.getAmount());
        assertEquals(moneyPlusOtherMoney.getAmount(), 3);
    }

    @Test
    void substractMoney() {
        Money money = new Money();
        Money otherMoney = new Money();

        money.setAmount(1);
        otherMoney.setAmount(2);
        Money moneySubstractOtherMoney = money.substractMoney(otherMoney);

        assertEquals(moneySubstractOtherMoney.getAmount(), money.getAmount() - otherMoney.getAmount());
        assertEquals(moneySubstractOtherMoney.getAmount(), -1);
    }

    @Test
    void multiplyMoney() {
        Money money = new Money();
        Money otherMoney = new Money();

        money.setAmount(1);
        otherMoney.setAmount(2);
        Money moneyMultipliedByOtherMoney = money.multiplyMoney(otherMoney);

        assertEquals(moneyMultipliedByOtherMoney.getAmount(), money.getAmount() * otherMoney.getAmount());
        assertEquals(moneyMultipliedByOtherMoney.getAmount(), 2);
    }

    @Test
    void lessThan() {
        Money money = new Money();
        Money otherMoney = new Money();

        money.setAmount(1);
        otherMoney.setAmount(2);
        boolean moneyIsLessThanOtherMoney = money.lessThan(otherMoney);

        assertTrue(moneyIsLessThanOtherMoney);
    }

    @Test
    void greaterThan() {
        Money money = new Money();
        Money otherMoney = new Money();

        money.setAmount(3);
        otherMoney.setAmount(2);
        boolean moneyIsGreaterThanOtherMoney = money.greaterThan(otherMoney);

        assertTrue(moneyIsGreaterThanOtherMoney);
    }

    @Test
    void equal() {
        Money money = new Money();
        Money otherMoney = new Money();

        money.setAmount(3);
        otherMoney.setAmount(3);
        boolean moneyIsEqualsOtherMoney = money.equal(otherMoney);

        assertTrue(moneyIsEqualsOtherMoney);

    }

    @Test
    void lessThanEqual() {
        Money money = new Money();
        Money otherMoney = new Money();
        Money anotherMoney = new Money();

        money.setAmount(3);
        otherMoney.setAmount(3);
        anotherMoney.setAmount(4);

        boolean moneyIsEquals = money.lessThanEqual(otherMoney);
        boolean moneyIsLessThanAnotherMoney = money.lessThanEqual(otherMoney);

        assertTrue(moneyIsEquals);
        assertTrue(moneyIsLessThanAnotherMoney);
    }

    @Test
    void greatherThanEqual() {
        Money money = new Money();
        Money otherMoney = new Money();
        Money anotherMoney = new Money();

        money.setAmount(3);
        otherMoney.setAmount(3);
        anotherMoney.setAmount(4);

        boolean moneyIsEquals = money.greatherThanEqual(otherMoney);
        boolean moneyIsGreaterThanAnotherMoney = money.greatherThanEqual(otherMoney);

        assertTrue(moneyIsEquals);
        assertTrue(moneyIsGreaterThanAnotherMoney);
    }
}