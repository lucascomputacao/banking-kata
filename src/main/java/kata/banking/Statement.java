package kata.banking;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Statement {
    private Date date;
    private Money amount;
    private Money balance;

    public Statement(Date date, Money amount, Money balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public String toString() {
        String dateStatement = getDateStringFormated();
        String prefixOfAmount = getPrefixOfAmount(amount.getMoneyAmount());
        String prefixOfBalanceAmount = getPrefixOfBalance(balance.getMoneyAmount());
        return String.format("%s  %s%s     %s%s\n", dateStatement,
                prefixOfAmount, amount.getMoneyAmount(), prefixOfBalanceAmount, balance.getMoneyAmount());
    }

    public String getDateStringFormated() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(date);
    }

    public String getPrefixOfAmount(int amount) { return  amount > 0  ? "+" : ""; }

    public String getPrefixOfBalance(int amount) { return amount >= 0 ? "" : "-"; }

    public Date getDate() { return date; }

    public Money getStatementAmount() { return amount; }

    public Money getStatementBalance() { return balance; }

}
