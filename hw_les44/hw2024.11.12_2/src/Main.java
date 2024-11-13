import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Smith", "John", 25, "Berlin"),
                new Person("Doe", "Jane", 25, "Berlin"),
                new Person("Brown", "Mike", 40, "Bonn"),
                new Person("Johnson", "Chris", 35, "Berlin"),
                new Person("Taylor", "Anna", 22, "Hamburg")
        );
        double avgAgeBerlin = calculateAverageAgeInBerlin(persons);
        System.out.println("Середній вік в Берліні: " + avgAgeBerlin);

        Map<Integer, Long> ageCountMap = getAgeCountMap(persons);
        System.out.println("Розподіл за віком: " + ageCountMap);

    }
    // Метод для отримання середнього віку людей в Берліні за допомогою reduce
    public static double calculateAverageAgeInBerlin(List<Person> people) {
        // Використовуємо reduce для підрахунку суми віків і кількості жителів Берліна
        int[] result = people.stream()
                .filter(p -> "Berlin".equals(p.getCity())) // Фільтруємо людей з Берліна
                .map(Person::getAge)                       // Преобразуємо потік об'єктів Person на потік віків
                .reduce(
                        new int[]{0, 0},                       // Початкове значення {сума віків, кількість людей}
                        (acc, age) -> new int[]{acc[0] + age, acc[1] + 1}, // Акумуляція: {сума + поточний вік, кількість + 1}
                        (a, b) -> new int[]{a[0] + b[0], a[1] + b[1]} // Злиття результатів (для паралельних стрімів)
                );

        // Обчислюємо середній вік
        return result[1] == 0 ? 0.0 : (double) result[0] / result[1];
    }

    // Метод для отримання Map з віком і кількістю людей (reduce не підходить для цієї задачі)
    public static Map<Integer, Long> getAgeCountMap(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getAge,
                        Collectors.counting()
                ));
    }
}