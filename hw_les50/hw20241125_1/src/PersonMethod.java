import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonMethod {

    //Метод для списку персон,відсортованих по віку(від старшого дод молодшого)
    public static List<Person> sortByAge  (List<Person> people){
        if (people.isEmpty()){
            return null;
        }
        return people.stream()
                .sorted(Comparator.comparing(Person::getBirthday))
                .toList();
    }
    //Метод для списку персон,народжених в заданому місяці
    public static List<Person> findByMonth(List<Person> people,int month){
        if (people.isEmpty()){
            return null;
        }
        return people.stream()
                .filter(person -> person.getBirthday().getMonthValue() == month)
                .toList();
    }
    //Метод для отримання різниці в днях між самим дорослим і самим юним
    public static long getAgeDifferenceInDay(List<Person> people){
        if (people.isEmpty()){
            return 0;
        }
        LocalDate old = people.stream()
                .min(Comparator.comparing(Person::getBirthday)).get().getBirthday();
        LocalDate young = people.stream()
                .max(Comparator.comparing(Person::getBirthday)).get().getBirthday();
        return ChronoUnit.DAYS.between(old,young);
    }
    //Метод для отримання ближньої дати народження
    public static LocalDate getNextBirthday (Person person ){
        LocalDate today = LocalDate.now();
        LocalDate nextBirthday = person.getBirthday().withYear(today.getYear());

        if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)){
            nextBirthday=nextBirthday.plusYears(1);
        }
        return nextBirthday;
    }
}
