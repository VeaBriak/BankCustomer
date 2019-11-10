package bank;

import java.util.regex.Pattern;

public abstract class Client {
    private static final Pattern MONEY_PATTERN = Pattern.compile("[0-9]*");

    static boolean isMoney(String string) {
        return MONEY_PATTERN.matcher(string).matches();
    }

    private int account;
    double balance;

    public Client() {

    }

    public Client(int account, double balance) {
        this.account = account;
        this.balance = balance;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void createBankAccount(int num) {
        setAccount(num);
    }

    public boolean withDrawMoney(String command) {
        if (!isMoney(command) || command.equals("")) {
            System.out.println("Вы не ввели сумму!");
        } else if (isMoney(command)) {
            double sum = Double.parseDouble(command);
            if (sum > balance) {
                System.out.println("Вы не можете снять эту сумму!\nДоступная сумма для снятия: " + balance + " руб.");
            } else {
                balance -= sum;
                System.out.println("Вы сняли " + sum + "\nБаланс на счете № " + getAccount() + " = " + balance + " руб.");
            }
        }
        return true;
    }

    public void putMoney(String command) {
        if (command.equals("") || !isMoney(command)) {
            System.out.println("На счет необходимо вносить деньги!");
        } else if (isMoney(command)) {
            setBalance(balance += Double.parseDouble(command));
            System.out.println("На счет поступило: " + command + "руб.");
        }
    }

    public void accounts() {
        System.out.println(getAccount() + " = " + getBalance() + "руб.\n");
    }

}
