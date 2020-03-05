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

    public void print() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String dateStatement = dateFormat.format(date);
        String prefixOfAmount = getPrefixOfAmount(amount.getAmount());
        String prefixOfBalanceAmount = getPrefixOfBalance(balance.getAmount());
        System.out.printf("%s  %s%s     %s%s\n", dateStatement,
                prefixOfAmount, amount.getAmount(), prefixOfBalanceAmount, balance.getAmount());
    }

    private String getPrefixOfAmount(int amount) {
        if (amount > 0)  return "+";
        return "";
    }
    private String getPrefixOfBalance(int amount) {
        return amount >= 0 ? " " : "-";
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }
}
