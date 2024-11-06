/*
testCorrectAccounts: Проверяет, что метод возвращает false, если все счета принадлежат правильным владельцам.
testOneIncorrectAccount: Проверяет, что метод возвращает true, если есть одна ошибка, где счет записан на неправильного владельца.
testMultipleIncorrectAccounts: Проверяет, что метод возвращает true, если в карте есть несколько ошибок с неправильными владельцами.
testEmptyMap: Проверяет, что метод возвращает false для пустой карты.
testAccountWithEmptyOwnerList: Проверяет, что метод возвращает false, если у владельца нет счетов в списке (пустой список счетов).
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


class MainTest {

    @Test
    void testCorrectAccounts() {
        Person john = new Person("John", "Doy");
        Person anna = new Person("Anna", "Karenina");

        Account account1 = new Account("DE123456789", BigDecimal.valueOf(1000), john);
        Account account2 = new Account("DE987654321", BigDecimal.valueOf(2000), anna);

        Map<Person, List<Account>> accountMap = Map.of(
                john, List.of(account1),
                anna, List.of(account2)
        );

        Assertions.assertFalse(Main.hasIncorrectAccounts(accountMap), "Ожидалась ошибка из-за одного неверного владельца счета");
    }

    @Test
    void testOneIncorrectAccount() {
        Person john = new Person("John", "Doy");
        Person anna = new Person("Anna", "Karenina");

        Account account1 = new Account("DE123456789", BigDecimal.valueOf(1000), john);
        Account account2 = new Account("DE987654321", BigDecimal.valueOf(2000), anna);

        Map<Person, List<Account>> accountMap = Map.of(
                john, List.of(account1, account2),
                anna, List.of()
        );

        Assertions.assertTrue(Main.hasIncorrectAccounts(accountMap), "Ожидалась ошибка из-за одного неверного владельца счета");
    }

    @Test
    void testMultipleIncorrectAccounts() {
        Person john = new Person("John", "Doy");
        Person anna = new Person("Anna", "Karenina");
        Person mark = new Person("Mark", "Twen");

        Account account1 = new Account("DE123456789", BigDecimal.valueOf(1000), john);
        Account account2 = new Account("DE987654321", BigDecimal.valueOf(2000), anna);
        Account account3 = new Account("DE555555555", BigDecimal.valueOf(1500), mark);

        Map<Person, List<Account>> accountMap = Map.of(
                john, List.of(account2),
                anna, List.of(account1),
                mark, List.of(account3)
        );

        Assertions.assertTrue(Main.hasIncorrectAccounts(accountMap), "Ожидаются ошибки из-за нескольких неверно указанных владельцев счетов");
    }

    @Test
    void testEmptyMap() {
        Map<Person, List<Account>> accountMap = Map.of(); // Empty map

        Assertions.assertFalse(Main.hasIncorrectAccounts(accountMap), "Ожидалось отсутствие ошибок для пустой карты");
    }

    @Test
    void testAccountWithEmptyOwnerList() {
        Person john = new Person("John", "Doy");
        Account account1 = new Account("DE123456789", BigDecimal.valueOf(1000), john);

        Map<Person, List<Account>> accountMap = Map.of(
                john, List.of()
        );

        Assertions.assertFalse(Main.hasIncorrectAccounts(accountMap), "Ожидалось отсутствие ошибок для карты с пустым списком счетов у владельца");
    }
}

