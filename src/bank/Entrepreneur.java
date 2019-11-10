package bank;

public class Entrepreneur extends Client {
    public Entrepreneur() {
    }

    public Entrepreneur(int account, double balance) {
        super(account, balance);
    }


    @Override
    public void createBankAccount(int num) {
        super.createBankAccount(num);
        System.out.println("Вы открыли счет №: " + getAccount() + " - для индивидуального предпринимателя");
    }

    @Override
    public boolean withDrawMoney(String command) {
        super.withDrawMoney(command);
        return true;
    }

    @Override
    public void putMoney(String command) {
        if (command.equals("") || !isMoney(command)) {
            System.out.println("На счет необходимо вносить деньги!");
        } else if (isMoney(command)) {
            double sum = Double.parseDouble(command);
            if (sum < 1000.0) {
                double percent = sum / 100;
                double money = sum - percent;
                setBalance(balance += money);
                System.out.println("На счет поступило: " + money + "руб.");
            } else if (sum >= 1000.0) {
                double percent = (sum / 100) * 0.5;
                double money = sum - percent;
                setBalance(balance += money);
                System.out.println("На счет поступило: " + money + "руб.");
            }
        }
    }
}
