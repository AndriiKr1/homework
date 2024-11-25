/*
Создайте класс Person (String name, LocalDate birthday ) Допустим у вас дан список людей. Напишите следующие методы:

метод, который позволяет получить список людей отсортированных по возрасту
метод, который позволяет получить список людей родившихся в заданном месяце
метод, который позволяет получить разницу в днях между самым взрослым и самым юным участником списка
метод, который позволяет получить дату ближайшего дня рождения
 */

import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Anna", LocalDate.of(1990, 5, 29)),
                new Person("John", LocalDate.of(1985, 8, 15)),
                new Person("Jack", LocalDate.of(1978, 12, 10)),
                new Person("Donald", LocalDate.of(2008, 12, 5)),
                new Person("Richard", LocalDate.of(2000, 1, 1))

        );
        System.out.println("Відсортований список по віку:");
        print(PersonMethod.sortByAge(people));
        System.out.println("\nНароджені в Грудні:");
        print(PersonMethod.findByMonth(people,12));
        System.out.println("\nРізниця по віку днях");
        long ageDifference = PersonMethod.getAgeDifferenceInDay(people);
        System.out.println(ageDifference);
        System.out.println("\nНайближче ДР для Anna");
        LocalDate nextBirthday = PersonMethod.getNextBirthday(people.get(0));
        System.out.println(nextBirthday);


    }
    public static void print(List<Person> people){
        for (Person person : people){
            System.out.println(person);
        }
    }
}