package kata.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void addMoney() {
        Money money = new Money(1);
        Money otherMoney = new Money(2);

        Money moneyPlusOtherMoney = money.addMoney(otherMoney);

        assertEquals(moneyPlusOtherMoney.getMoneyAmount(), money.getMoneyAmount() + otherMoney.getMoneyAmount());
        assertEquals(moneyPlusOtherMoney.getMoneyAmount(), 3);
    }

    @Test
    void substractMoney() {
        Money money = new Money(1);
        Money otherMoney = new Money(2);

        Money moneySubstractOtherMoney = money.substractMoney(otherMoney);

        assertEquals(moneySubstractOtherMoney.getMoneyAmount(), money.getMoneyAmount() - otherMoney.getMoneyAmount());
        assertEquals(moneySubstractOtherMoney.getMoneyAmount(), -1);
    }

    @Test
    void multiplyMoney() {
        Money money = new Money(1);
        Money otherMoney = new Money(2);

        Money moneyMultipliedByOtherMoney = money.multiplyMoney(otherMoney);

        assertEquals(moneyMultipliedByOtherMoney.getMoneyAmount(), money.getMoneyAmount() * otherMoney.getMoneyAmount());
        assertEquals(moneyMultipliedByOtherMoney.getMoneyAmount(), 2);
    }

    @Test
    void lessThan() {
        Money money = new Money(1);
        Money otherMoney = new Money(2);

        boolean moneyIsLessThanOtherMoney = money.lessThan(otherMoney);

        assertTrue(moneyIsLessThanOtherMoney);
    }

    @Test
    void greaterThan() {
        Money money = new Money(3);
        Money otherMoney = new Money(2);

        boolean moneyIsGreaterThanOtherMoney = money.greaterThan(otherMoney);

        assertTrue(moneyIsGreaterThanOtherMoney);
    }

    @Test
    void equal() {
        Money money = new Money(3);
        Money otherMoney = new Money(3);

        boolean moneyIsEqualsOtherMoney = money.equal(otherMoney);

        assertTrue(moneyIsEqualsOtherMoney);

    }

    @Test
    void lessThanEqual() {
        Money money = new Money(3);
        Money otherMoney = new Money(3);
        Money anotherMoney = new Money(4);

        boolean moneyIsEquals = money.lessThanEqual(otherMoney);
        boolean moneyIsLessThanAnotherMoney = money.lessThanEqual(otherMoney);

        assertTrue(moneyIsEquals);
        assertTrue(moneyIsLessThanAnotherMoney);
    }

    @Test
    void greatherThanEqual() {
        Money money = new Money(3);
        Money otherMoney = new Money(3);
        Money anotherMoney = new Money(4);

        boolean moneyIsEquals = money.greatherThanEqual(otherMoney);
        boolean moneyIsGreaterThanAnotherMoney = money.greatherThanEqual(otherMoney);

        assertTrue(moneyIsEquals);
        assertTrue(moneyIsGreaterThanAnotherMoney);
    }
}