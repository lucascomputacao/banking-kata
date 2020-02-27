
package kata.banking;



public interface Account {
    String printStatement();

    void deposit(Integer value);

    void withDraw(Integer value);

    String getMoneyStored();
}
