package kata.banking;

public class AccountWithMoney {
    private Money moneyStored;

    public AccountWithMoney(Money moneyStored) {
        this.moneyStored = moneyStored;
    }

    public String printStatement() {
        return null;
    }

    public void deposit(Money valueToDeposit) {
        moneyStored.addMoney(valueToDeposit);
    }

    public void withDraw(Money withDrawValue) {
        if (moneyStored.getAmount() >= withDrawValue.getAmount()) {
            moneyStored = moneyStored.substractMoney(withDrawValue);
        }
    }

    public Money getMoneyStored() {
        return moneyStored;
    }

}
