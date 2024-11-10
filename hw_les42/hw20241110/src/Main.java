/*
1.
Дан список  BankAccount {Person owner, String IBAN, double balance). Класс Person состоит из {String fName, String lName String email). Используя stream необходимо получить:

map где ключом будет owner (Person), а значением будет баланс (Double)
map где ключом будет IBAN (String), а значением будет owner (Person)
map где ключом будет IBAN (String), а значением будет строка  J.Jack (т.e. первая буква fName и lName)

В рамках данной задачи person и account  уникальны и у каждого owner a единственный счет.

2 (чуть сложнее)
Дана Map <String, BankAccount,> ключ это email. Ваша задача используя стримы лист из имен 3 самых крупных клиентов (т.е. тех у кого на счету самый большой остаток)
 */


import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<BankAccount> accounts = List.of(
                new BankAccount(new Person("Max", "Muster", "max@gmail.com"), "DE1234567890", 5000.0),
                new BankAccount(new Person("Erika", "Muster", "erika@gmail.com"), "DE0987654321", 7500.0),
                new BankAccount(new Person("Hans", "Schmidt", "hans@gmail.com"), "DE1122334455", 3000.0),
                new BankAccount(new Person("Petra", "Meyer", "petra@gmail.com"), "DE2233445566", 6500.0)
        );
        BankAccountService result = new BankAccountService();
        System.out.println("Власник -> Баланс: " + result.getOwnerToBalanceMap(accounts));
        System.out.println("------------------------------------------------------------------------");
        System.out.println("IBAN -> Власник: " + result.getIbanToOwnerMap(accounts));
        System.out.println("------------------------------------------------------------------------");
        System.out.println("IBAN -> Ініціали: " + result.getIbanToInitialMap(accounts));
        System.out.println("------------------------------------------------------------------------");

        Map<String, BankAccount> accountMap = Map.of(
                "max@gmail.com", new BankAccount(new Person("Max", "Muster", "max@gmail.com"), "DE1234567890", 5000.0),
                "erika@gmail.com", new BankAccount(new Person("Erika", "Muster", "erika@gmail.com"), "DE0987654321", 7500.0),
                "hans@gmail.com", new BankAccount(new Person("Hans", "Schmidt", "hans@gmail.com"), "DE1122334455", 3000.0),
                "petra@gmail.com", new BankAccount(new Person("Petra", "Meyer", "petra@gmail.com"), "DE2233445566", 6500.0),
                "klaudia@gmail.com", new BankAccount(new Person("Klaudia", "Schneider", "klaudia@gmail.com"), "DE6677889900", 8000.0)
        );

        System.out.println("Топ 3 клієнти: " + result.getTopClientsByBalance(accountMap));

    }
}