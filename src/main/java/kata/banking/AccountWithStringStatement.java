package kata.banking;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AccountWithStringStatement implements Account {
    public static final String NOT_ALLOWED_DEPOSIT_VALUES = "You can't deposit illegal values";
    private static final Integer ZERO = 0;
    ArrayList<String> bankStatementRegister = new ArrayList<>();
    Integer moneyStored = 0;
    String statementString = "Date              Amount        Balance\n";


    public void deposit(Integer money) {
        // deposita na conta
        depositMoneyInAccount(money);
    }

    private void depositMoneyInAccount(Integer money) {
        if (money <= 0) {
            log(NOT_ALLOWED_DEPOSIT_VALUES);
        } else {
            moneyStored =+ money;
            statementRegister(money);
        }

    }

    private String getDateFormated() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(date);
    }

    public void withDraw(Integer money) {
        if (moneyStored >= money) {
            // to prevent calculation errors with Integer signal
            money = turnsWithDrawInNegativeValueIfNeeded(money);
            moneyStored = moneyStored + money;
            statementRegister(money);
        } else {
            log("You don't have this amount of money!");
        }
    }

    private Integer turnsWithDrawInNegativeValueIfNeeded(Integer money) {
        if (money > ZERO) {
            money *= -1;
        }
        return money;
    }

    public String printStatement() {
        if (!bankStatementRegister.isEmpty()) {
            bankStatementRegister.forEach( s -> {
                log("\nConcating statementString: \n" + statementString.concat(s) + "\n");
                statementString += s + "\n";
            });
        }
        return statementString;
    }


    private String statementRegister(Integer depositMoney) {
        // Statement format:
        // Date        Amount  Balance
        //24.12.2015   +500      500
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String statement = dateFormat.format(date);
        statement += "        " + getMoneyPrefix(depositMoney) + "" + depositMoney;
        statement += "             " + getMoneyStored();
        log("\nSaving New Statement: ");
        log("Date              Amount        Balance\n" + statement);

        bankStatementRegister.add(statement);
        return statement;
    }

    private String getMoneyPrefix(Integer depositMoney) {
        String prefixMoney = "";
        if (depositMoney > ZERO)
            prefixMoney = "+";
        return prefixMoney;
    }

    public String getMoneyStored() {
        return moneyStored.toString();
    }

    private void log(String logString) {
        System.out.print(logString);
    }
}