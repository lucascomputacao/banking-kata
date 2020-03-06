package kata.banking;

import java.util.ArrayList;
import java.util.Calendar;

public class AccountWithMoney {
    // Initializing account without Money
    private Money moneyStored = new Money(0);
    private ArrayList<Statement> statementList = new ArrayList<>();

    public String printListOfStatements() {
        StringBuilder listOfStatements = new StringBuilder();
        listOfStatements.append("\nDate        Amount  Balance\n");
        statementList.forEach(statement -> listOfStatements.append(statement.toString()));
        return listOfStatements.toString();
    }

    public void deposit(Money valueToDeposit) {
        moneyStored = moneyStored.addMoney(valueToDeposit);
        recordStatement(valueToDeposit);
    }

    public void withDraw(Money withDrawValue) throws Exception {
        if (moneyStored.lessThan(withDrawValue)){
            throw new Exception("Insuficient amount in Account");
        }
        moneyStored = moneyStored.substractMoney(withDrawValue);
        withDrawValue = withDrawValue.multiplyMoney(new Money(-1));
        recordStatement(withDrawValue);
    }

    public Money getMoneyStored() {
        return moneyStored;
    }

    private void recordStatement(Money amountToSave) {
        statementList.add(new Statement(Calendar.getInstance().getTime(), amountToSave, moneyStored));
    }

}
