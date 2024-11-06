import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;


class MainTest {

    // Тест на случай, когда в списке есть повторяющиеся строки
    @Test
    void testDuplicatesInList() {
        List<String> str = List.of("jack", "john", "nick", "jack", "mike", "ann", "john");

        Map<String, Boolean> result = Main.checkStringDuplicates(str);

        // Проверяем, что для "jack" и "john" значение true, потому что они повторяются
        Assertions.assertTrue(result.get("jack"), "Ожидалось, что 'jack' будет true, так как он встречается более одного раза");
        Assertions.assertTrue(result.get("john"), "Ожидалось, что 'john' будет true, так как он встречается более одного раза");

        // Проверяем, что для "nick", "mike", "ann" значение false, так как они не повторяются
        Assertions.assertFalse(result.get("nick"), "Ожидалось, что 'nick' будет false, так как он встречается только один раз");
        Assertions.assertFalse(result.get("mike"), "Ожидалось, что 'mike' будет false, так как он встречается только один раз");
        Assertions.assertFalse(result.get("ann"), "Ожидалось, что 'ann' будет false, так как он встречается только один раз");
    }

    // Тест на случай, когда в списке нет повторяющихся строк
    @Test
    void testNoDuplicatesInList() {
        List<String> str = List.of("jack", "john", "nick", "mike", "ann");

        Map<String, Boolean> result = Main.checkStringDuplicates(str);

        // Все значения должны быть false, так как нет повторений
        Assertions.assertFalse(result.get("jack"), "Ожидалось, что 'jack' будет false, так как он встречается только один раз");
        Assertions.assertFalse(result.get("john"), "Ожидалось, что 'john' будет false, так как он встречается только один раз");
        Assertions.assertFalse(result.get("nick"), "Ожидалось, что 'nick' будет false, так как он встречается только один раз");
        Assertions.assertFalse(result.get("mike"), "Ожидалось, что 'mike' будет false, так как он встречается только один раз");
        Assertions.assertFalse(result.get("ann"), "Ожидалось, что 'ann' будет false, так как он встречается только один раз");
    }

    // Тест на случай, когда список null
    @Test
    void testNullList() {
        List<String> str = null;

        Map<String, Boolean> result = Main.checkStringDuplicates(str);

        // Проверяем, что метод корректно обрабатывает null и возвращает пустую Map
        Assertions.assertNotNull(result, "Ожидалась не-null карта для входного списка, равного null");
        Assertions.assertTrue(result.isEmpty(), "Ожидалась пустая карта для входного списка, равного null");
    }
}

