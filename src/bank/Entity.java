package bank;

public class Entity extends Client {
    public Entity() {
    }

    public Entity(int account, double balance) {
        super(account, balance);
    }


    @Override
    public void createBankAccount(int num) {
        super.createBankAccount(num);
        System.out.println("Вы открыли счет №: " + getAccount() + " - для юридического лица");
    }

    @Override
    public boolean withDrawMoney(String command) {
        if (!isMoney(command) || command.equals("")) {
            System.out.println("Вы не ввели сумму!");
        } else if (isMoney(command)) {
            double sum = Double.parseDouble(command);
            if (balance == 0.0) {
                System.out.println("Вы не можете снять эту сумму!\nДоступная сумма для снятия: " + balance + " руб.");
            } else if (sum >= balance) {
                double percent = sum / 100;
                double money = balance - percent;
                System.out.println("Вы не можете снять эту сумму!\nДоступная сумма для снятия: " + money + " руб.");
            } else {
                double percent = sum / 100;
                balance -= sum;
                balance = balance - percent;
                System.out.println("Вы сняли " + sum + "\nБаланс на счете № " + getAccount() + " = " + balance + " руб.");
            }
        }
        return true;
    }

    @Override
    public void putMoney(String command) {
        super.putMoney(command);
    }
}
