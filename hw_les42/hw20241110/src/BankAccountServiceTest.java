import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.*;

class BankAccountServiceTest {

    private BankAccountService service;
    private List<BankAccount> accounts;

    @BeforeEach
    void setUp() {
        service = new BankAccountService();
        accounts = List.of(
                new BankAccount(new Person("Max", "Muster", "max@gmail.com"), "DE1234567890", 5000.0),
                new BankAccount(new Person("Erika", "Muster", "erika@gmail.com"), "DE0987654321", 7500.0),
                new BankAccount(new Person("Hans", "Schmidt", "hans@gmail.com"), "DE1122334455", 3000.0),
                new BankAccount(new Person("Petra", "Meyer", "petra@gmail.com"), "DE2233445566", 6500.0)
        );
    }

    @Test
    void testGetOwnerToBalanceMap() {
        Map<Person, Double> expectedResult = new HashMap<>();
        expectedResult.put(new Person("Max", "Muster", "max@gmail.com"), 5000.0);
        expectedResult.put(new Person("Erika", "Muster", "erika@gmail.com"), 7500.0);
        expectedResult.put(new Person("Hans", "Schmidt", "hans@gmail.com"), 3000.0);
        expectedResult.put(new Person("Petra", "Meyer", "petra@gmail.com"), 6500.0);

        Map<Person, Double> actualResult = service.getOwnerToBalanceMap(accounts);

        Assertions.assertEquals(expectedResult, actualResult, "Результат мапи власників і балансів має відповідати очікуваному");
    }

    @Test
    void testGetIbanToOwnerMap() {
        Map<String, Person> expectedResult = new HashMap<>();
        expectedResult.put("DE1234567890", new Person("Max", "Muster", "max@gmail.com"));
        expectedResult.put("DE0987654321", new Person("Erika", "Muster", "erika@gmail.com"));
        expectedResult.put("DE1122334455", new Person("Hans", "Schmidt", "hans@gmail.com"));
        expectedResult.put("DE2233445566", new Person("Petra", "Meyer", "petra@gmail.com"));

        Map<String, Person> actualResult = service.getIbanToOwnerMap(accounts);

        Assertions.assertEquals(expectedResult, actualResult, "Результат мапи IBAN і власників має відповідати очікуваному");
    }

    @Test
    void testGetIbanToInitialMap() {
        Map<String, String> expectedResult = new HashMap<>();
        expectedResult.put("DE1234567890", "M.Muster");
        expectedResult.put("DE0987654321", "E.Muster");
        expectedResult.put("DE1122334455", "H.Schmidt");
        expectedResult.put("DE2233445566", "P.Meyer");

        Map<String, String> actualResult = service.getIbanToInitialMap(accounts);

        Assertions.assertEquals(expectedResult, actualResult, "Результат мапи IBAN і ініціалів має відповідати очікуваному");
    }

    @Test
    void testGetTopClientsByBalance() {
        Map<String, BankAccount> accountMap = Map.of(
                "max@gmail.com", new BankAccount(new Person("Max", "Muster", "max@gmail.com"), "DE1234567890", 5000.0),
                "erika@gmail.com", new BankAccount(new Person("Erika", "Muster", "erika@gmail.com"), "DE0987654321", 7500.0),
                "hans@gmail.com", new BankAccount(new Person("Hans", "Schmidt", "hans@gmail.com"), "DE1122334455", 3000.0),
                "petra@gmail.com", new BankAccount(new Person("Petra", "Meyer", "petra@gmail.com"), "DE2233445566", 6500.0),
                "klaudia@gmail.com", new BankAccount(new Person("Klaudia", "Schneider", "klaudia@gmail.com"), "DE6677889900", 8000.0)
        );

        List<String> expectedResult = List.of( "Klaudia Schneider", "Erika Muster","Petra Meyer");

        List<String> actualResult = service.getTopClientsByBalance(accountMap);

        Assertions.assertIterableEquals(expectedResult, actualResult, "Список топ-клієнтів має відповідати очікуваному");
    }

    // Тести для випадків з порожніми або null списками/картами

    @Test
    void testGetOwnerToBalanceMap_EmptyList() {
        List<BankAccount> emptyAccounts = Collections.emptyList();
        Map<Person, Double> expectedResult = Collections.emptyMap();
        Map<Person, Double> actualResult = service.getOwnerToBalanceMap(emptyAccounts);
        Assertions.assertEquals(expectedResult, actualResult, "Якщо список порожній, то результат має бути порожнім");
    }

    @Test
    void testGetIbanToOwnerMap_NullList() {
        Map<String, Person> expectedResult = Collections.emptyMap();
        Map<String, Person> actualResult = service.getIbanToOwnerMap(null);
        Assertions.assertEquals(expectedResult, actualResult, "Якщо список null, то результат має бути порожнім");
    }

    @Test
    void testGetIbanToInitialMap_EmptyList() {
        List<BankAccount> emptyAccounts = Collections.emptyList();
        Map<String, String> expectedResult = Collections.emptyMap();
        Map<String, String> actualResult = service.getIbanToInitialMap(emptyAccounts);
        Assertions.assertEquals(expectedResult, actualResult, "Якщо список порожній, то результат має бути порожнім");
    }

    @Test
    void testGetTopClientsByBalance_EmptyMap() {
        Map<String, BankAccount> emptyMap = Collections.emptyMap();
        List<String> expectedResult = Collections.emptyList();
        List<String> actualResult = service.getTopClientsByBalance(emptyMap);
        Assertions.assertEquals(expectedResult, actualResult, "Якщо карта порожня, то результат має бути порожнім");
    }
}
