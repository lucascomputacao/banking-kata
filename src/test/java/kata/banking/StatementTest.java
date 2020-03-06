package kata.banking;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatementTest {

    @Test
    void testToString() {
        Money amount = new Money(10);
        Money balance = new Money(50);
        Statement statement = new Statement(Calendar.getInstance().getTime(), amount, balance);

        String actualStatement = statement.toString();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String dateStatement = dateFormat.format(Calendar.getInstance().getTime());
        String expectedString = dateStatement
                + "  " + statement.getPrefixOfAmount(amount.getMoneyAmount())+ amount.getMoneyAmount() + "     "
                + balance.getMoneyAmount() + "\n";

        assertEquals(actualStatement, expectedString);
    }

    @Test
    void testGetPrefixOfAmountReturnsEmptyStringForNegativeValueOfAmount() {
        Money amount = new Money(-10);
        Money balance = new Money(100);
        Statement statement = new Statement(Calendar.getInstance().getTime(), amount, balance);

        String prefixOfAmount = statement.getPrefixOfAmount(amount.getMoneyAmount());

        assertEquals(prefixOfAmount, "");
    }

    @Test
    void testGetPrefixOfAmountReturnsPlusStringForPositiveValuesOfAmount() {
        Money amount = new Money(10);
        Money balance = new Money(80);
        Statement statement = new Statement(Calendar.getInstance().getTime(), amount, balance);

        String prefixOfAmount = statement.getPrefixOfAmount(amount.getMoneyAmount());

        assertEquals(prefixOfAmount, "+");
    }

    @Test
    void getDateFormatShouldReturnDate() {
        Money amount = new Money(10);
        Money balance = new Money(50);
        Statement statement = new Statement(Calendar.getInstance().getTime(), amount, balance);

        String dateOfStatement = statement.getDate().toString();
        String expectedDate = Calendar.getInstance().getTime().toString();

        assertEquals(dateOfStatement, expectedDate);
    }

    @Test
    void getDateFormatShouldReturnFormatedDate() {
        Money amount = new Money(10);
        Money balance = new Money(20);
        Statement statement = new Statement(Calendar.getInstance().getTime(), amount, balance);

        String dateOfStatement = statement.getDateStringFormated();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String expectedDateFormated = dateFormat.format(Calendar.getInstance().getTime());

        assertEquals(dateOfStatement, expectedDateFormated);
    }

    @Test
    void getAmountTest() {
        Money amount = new Money(10);
        Money balance = new Money(30);
        Statement statement = new Statement(Calendar.getInstance().getTime(), amount, balance);

        Integer actualAmount = statement.getStatementAmount().getMoneyAmount();

        assertEquals(actualAmount, amount.getMoneyAmount());
    }

    @Test
    void getStatementBalanceTest() {
        Money amount = new Money(10);
        Money balance = new Money(10000);
        Statement statement = new Statement(Calendar.getInstance().getTime(), amount, balance);

        Money actualBalance = statement.getStatementBalance();

        assertEquals(actualBalance, balance);
        assertEquals(actualBalance.getMoneyAmount(), balance.getMoneyAmount());
    }

}