package kata.banking;

public class Money {
    private int amount;

    private Money newMoney(int amount) {
        Money money = new Money();
        money.amount = amount;
        return money;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }
    public int getAmount() {
        return amount;
    }

    public Money addMoney(Money otherMoney) {
        return newMoney(amount + otherMoney.amount);
    }

    public Money substractMoney(Money otherMoney) {
        return newMoney(amount - otherMoney.amount);
    }

    public Money multiplyMoney(Money otherMoney) {
        return newMoney(amount * otherMoney.amount);
    }

    public boolean lessThan(Money otherMoney) {
        return compare(otherMoney) == -1;
    }

    public boolean greaterThan(Money otherMoney) {
        return compare(otherMoney) == 1;
    }

    public boolean equal(Money otherMoney) {
        return compare(otherMoney) == 0;
    }

    public boolean lessThanEqual(Money otherMoney) {
        return lessThan(otherMoney) || equal(otherMoney);
    }

    public boolean greatherThanEqual(Money otherMoney) {
        return greaterThan(otherMoney) || equal(otherMoney);
    }
    private int compare(Money otherMoney) {
        // Integer.compare(x,y) => return (x < y) ? -1 : ((x == y) ? 0 : 1);
        return Integer.compare(amount, otherMoney.amount);
    }
}
