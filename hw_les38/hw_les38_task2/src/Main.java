import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Person john = new Person("John","Doy");
        Person anna = new Person("Anna","Karenina");

        Account account1 = new Account("DE123456789", BigDecimal.valueOf(1000), john);
        Account account2 = new Account("DE987654321", BigDecimal.valueOf(2000), anna);
        Account account3 = new Account("DE555555555", BigDecimal.valueOf(1500), john); // Неправильно записанный счет

        Map<Person, List<Account>> accountMap = Map.of(
                john, List.of(account1,account2), // Ошибка: account2 принадлежит Анне
                anna, List.of(account3) // Ошибка: account3 принадлежит Джону
        );

        if (hasIncorrectAccounts(accountMap)) {
            System.out.println("Обнаружены ошибки в карте аккаунтов.");
        } else {
            System.out.println("Ошибок не найдено.");
        }

    }
    public static boolean hasIncorrectAccounts(Map<Person, List<Account>> accountMap) {
        for (Map.Entry<Person, List<Account>> entry : accountMap.entrySet()) {
            Person person = entry.getKey();
            List<Account> accounts = entry.getValue();

            for (Account account : accounts) {
                if (!account.getOwner().equals(person)) {
                    System.out.println("Ошибка: Счет " + account + " записан под неправильным владельцем " + person);
                    return true; // Возвращаем true при первой найденной ошибке
                }
            }
        }
        return false; // Если все корректно, возвращаем false
    }
}