import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

class PersonMethodTest {

    private final List<Person> people = List.of(
            new Person("Anna", LocalDate.of(1990, 5, 29)),
            new Person("John", LocalDate.of(1985, 8, 15)),
            new Person("Jack", LocalDate.of(1978, 12, 10)),
            new Person("Donald", LocalDate.of(2008, 12, 5)),
            new Person("Richard", LocalDate.of(2000, 1, 1))
            );

    @Test
    void sortByAge() {
                List<Person> sorted = PersonMethod.sortByAge(people);
        Assertions.assertEquals("Jack",sorted.get(0).getName());
        Assertions.assertEquals("Donald",sorted.get(sorted.size()-1).getName());
    }

    @Test
    void findByMonth() {
        List<Person> bornInDecember = PersonMethod.findByMonth(people,12);
        Assertions.assertEquals(2,bornInDecember.size());
        Assertions.assertTrue(bornInDecember.stream().anyMatch(person -> person.getName().equals("Jack")));
        Assertions.assertTrue(bornInDecember.stream().anyMatch(person -> person.getName().equals("Donald")));
    }

    @Test
    void getAgeDifferenceInDay() {
        long ageDifference = PersonMethod.getAgeDifferenceInDay(people);
        Assertions.assertTrue(ageDifference > 0); // Перевіряємо, що різниця додатна

    }

    @Test
    void getNextBirthday() {
        Person person = new Person("Anna", LocalDate.of(1990, 5, 29));
        LocalDate today = LocalDate.now();
        LocalDate nextBirthday = PersonMethod.getNextBirthday(person);

        // Наступний день народження має бути після сьогоднішнього дня
        Assertions.assertTrue(nextBirthday.isAfter(today) || nextBirthday.isEqual(today));

        // Перевіряємо, чи наступний день народження вірно обчислений
        Assertions.assertEquals(today.getYear() + (today.isAfter(LocalDate.of(today.getYear(), 5, 29)) ? 1 : 0), nextBirthday.getYear());
        Assertions.assertEquals(5, nextBirthday.getMonthValue());
        Assertions.assertEquals(29, nextBirthday.getDayOfMonth());
    }
}