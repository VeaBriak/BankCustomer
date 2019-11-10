package bank;

public class Individuals extends Client {

    public Individuals() {
    }

    public Individuals(int account, double balance) {
        super(account, balance);
    }

    @Override
    public void createBankAccount(int num) {
        super.createBankAccount(num);
        System.out.println("Вы открыли счет №: " + getAccount() + " - для физического лица");
    }

    @Override
    public boolean withDrawMoney(String command) {
        super.withDrawMoney(command);
        return true;
    }

    @Override
    public void putMoney(String command) {
        super.putMoney(command);
    }
}
