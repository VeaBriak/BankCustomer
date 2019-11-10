import bank.Entity;
import bank.Entrepreneur;
import bank.Individuals;

import java.util.Scanner;

/**Реализуйте классы, представляющие клиентов банка: абстрактный класс Client, а также классы для физических лиц, юридических лиц и индивидуальных предпринимателей.
 *  У каждого клиента есть расчётный счёт (число), который можно пополнять, с которого можно снимать, и баланс на котором можно смотреть.
 *  Реализовать методы таким образом, чтобы у физических лиц пополнение и снятие происходило без комиссии, у юридических лиц — снятие с комиссией 1%,
 *  а у ИП — пополнение с комиссией 1%, если сумма меньше 1000 рублей, и 0,5%, если сумма больше либо равна 1000 рублей.**/

public class Mian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Individuals individual = new Individuals();
        Entity entity = new Entity();
        Entrepreneur entrepreneur = new Entrepreneur();

        for (; ; ) {
            System.out.println("Какой счет хотите открыть? \n" +
                    " - ind - счет для физического лица;\n" +
                    " - ent - счет для юридического лица;\n" +
                    " - entr - счет для индивидуального предпринимателя:\n" +
                    " - accounts - список всех счетов\n" +
                    " - end - выход из приложения");
            String command = scanner.nextLine().trim();
            if (command.equals("ind")) {
                System.out.println("Введите номер счета:");
                int num = scanner.nextInt();
                individual.createBankAccount(num);
                for (; ; ) {
                    print();
                    command = scanner.nextLine().trim();
                    if (command.equals("Put")) {
                        System.out.println("Внесите деньги на счет:");
                        command = scanner.nextLine().trim();
                        individual.putMoney(command);
                    } else if (command.equals("Cash")) {
                        System.out.println("Какую сумму снять?:");
                        command = scanner.nextLine().trim();
                        individual.withDrawMoney(command);
                    } else if (command.equals("Balance")) {
                        System.out.println("Баланс на счете  № " + individual.getAccount() + " = " + individual.getBalance() + " руб.");
                    } else if (command.equals("Exit")) {
                        break;
                    }
                }
            } else if (command.equals("ent")) {
                System.out.println("Введите номер счета:");
                int num = scanner.nextInt();
                entity.createBankAccount(num);
                for (; ; ) {
                    print();
                    command = scanner.nextLine().trim();
                    if (command.equals("Put")) {
                        System.out.println("Внесите деньги на счет:");
                        command = scanner.nextLine().trim();
                        entity.putMoney(command);
                    } else if (command.equals("Cash")) {
                        System.out.println("При снятии взымается комиссия 1%.\nКакую сумму снять?:");
                        command = scanner.nextLine().trim();
                        entity.withDrawMoney(command);
                    } else if (command.equals("Balance")) {
                        System.out.println("Баланс на счете  № " + entity.getAccount() + " = " + entity.getBalance() + " руб.");
                    } else if (command.equals("Exit")) {
                        break;
                    }
                }
            } else if (command.equals("entr")) {
                System.out.println("Введите номер счета:");
                int num = scanner.nextInt();
                entrepreneur.createBankAccount(num);
                for (; ; ) {
                    print();
                    command = scanner.nextLine().trim();
                    if (command.equals("Put")) {
                        System.out.println("При внесении на счет суммы меньше 1000 рублей взымается комиссия 1%,\n" +
                                "и 0,5%, если сумма больше или равна 1000 руб.\n" +
                                "Внесите деньги на счет:");
                        command = scanner.nextLine().trim();
                        entrepreneur.putMoney(command);
                    } else if (command.equals("Cash")) {
                        System.out.println("Какую сумму снять?:");
                        command = scanner.nextLine().trim();
                        entrepreneur.withDrawMoney(command);
                    } else if (command.equals("Balance")) {
                        System.out.println("Баланс на счете  № " + entrepreneur.getAccount() + " = " + entrepreneur.getBalance() + " руб.");
                    } else if (command.equals("Exit")) {
                        break;
                    }
                }
            } else if (command.equals("accounts")) {
                System.out.println("Список № счетов с балансом:\n");
                individual.accounts();
                entity.accounts();
                entrepreneur.accounts();
            } else if (command.equals("end")) {
                System.out.println("Выход из приложения!");
                break;
            }
        }
    }

    public static void print(){
        System.out.println("==============================" +
                "\nКакую операцию произвести:" +
                "\nPut - внести деньги на счет" +
                "\nCash - обналичить" +
                "\nBalance - проверить остаток" +
                "\nExit - выход");
    }
}
