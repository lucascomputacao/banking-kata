/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package kata.banking;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static kata.banking.AccountWithStringStatement.NOT_ALLOWED_DEPOSIT_VALUES;
import static org.junit.jupiter.api.Assertions.*;

class AccountWithStringStatementTest {

    public static final String BASIC_STATEMENT_STRING = "Date              Amount        Balance\n";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void shouldDepositAndStoreMoneyCorrectly() {
        //GIVEN
        Account account = new AccountWithStringStatement();
        Integer money = 500;

        //WHEN
        account.deposit(money);

        //THEN
        assert(account.getMoneyStored().equals(money.toString()));
    }

    @Test
    public void depositWithValuesLessThanZeroShouldBeRejectedWithMessage() {
        //GIVEN
        Account account = new AccountWithStringStatement();
        Integer money = 0;
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //WHEN
        account.deposit(money);

        //THEN
        assertEquals(NOT_ALLOWED_DEPOSIT_VALUES, outContent.toString());
    }


    @Test
    public void printStatementShouldBeBasicStringWhenWeDontHaveMoneyInAccount() {
        //GIVEN
        Account account = new AccountWithStringStatement();

        //WHEN
        String printStatement = account.printStatement();

        //THEN
        assert(printStatement.equals(BASIC_STATEMENT_STRING));
    }

    @Test
    public void printStatementShouldReturnNonEmptyStringWhenWeHaveSomeMoneyInAccount() {
        //GIVEN
        Account account = new AccountWithStringStatement();
        Integer money = 500;
        account.deposit(money);
        Integer money2 = 100;
        account.withDraw(money2);
        String dateFormated = getDateFormated();
        String expectedStatement =
                BASIC_STATEMENT_STRING +
                dateFormated + "        +500             500\n" +
                dateFormated + "        -100             400";

        //WHEN
        String statement = account.printStatement();
        int sum = money - money2;
        String sumString = Integer.toString(sum);

        //THEN
        assert(statement.contains(expectedStatement));
        assertEquals(account.getMoneyStored(), sumString);
    }

    private String getDateFormated() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(date);
    }

    @Test
    public void withDrawShouldBeDoneCorrectly() {
        // GIVEN
        Account account = new AccountWithStringStatement();
        account.deposit(100);

        // WHEN
        account.withDraw(100);

        // THEN
        assertEquals(account.getMoneyStored(), Integer.toString(0));
    }

    @Test
    public void withDrawWithEnoughResources() {
        //GIVEN
        Account account = new AccountWithStringStatement();
        account.deposit(100);
        String dateFormated = getDateFormated();
        String expectedStatement =
                BASIC_STATEMENT_STRING +
                        dateFormated + "        +100             100";

        //WHEN
        account.withDraw(200);
        String statement = account.printStatement();

        //THEN
        assertEquals(account.getMoneyStored(), Integer.toString(100));
        assert(statement.contains(expectedStatement));
    }

}
