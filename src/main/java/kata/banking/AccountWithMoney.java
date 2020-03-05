package kata.banking;

import java.util.ArrayList;
import java.util.Calendar;

public class AccountWithMoney {

    private Money moneyStored = new Money();
    private ArrayList<Statement> statementList = new ArrayList<>();

    public void printListOfStatements() {
        System.out.println("\nDate        Amount  Balance");
        statementList.forEach(statement -> {
            System.out.println(statement.toString());
        });
    }

    public void deposit(Money valueToDeposit) {
        moneyStored = moneyStored.addMoney(valueToDeposit);

        Statement statement = new Statement(Calendar.getInstance().getTime(), valueToDeposit,
                moneyStored);
        statementList.add(statement);
    }

    public void withDraw(Money withDrawValue) {
        final Money MINUS_ONE_MONEY = new Money().newMoney(-1);
        if (moneyStored.lessThan(withDrawValue)){
            return;
        }
        moneyStored = moneyStored.substractMoney(withDrawValue);
        withDrawValue = withDrawValue.multiplyMoney(MINUS_ONE_MONEY);
        statementList.add(new Statement(Calendar.getInstance().getTime(), withDrawValue, moneyStored));
    }

    public Money getMoneyStored() {
        return moneyStored;
    }

}
