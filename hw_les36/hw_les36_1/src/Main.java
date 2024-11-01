// Andrii Kryshtapovych cohort 53
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Руководство компании решило премировать сотрудников. Каждый team lead подал список сотрудников для получения премии.
Но получилось так, что некоторые сотрудники работают на нескольких проектах и попали в списки несколько раз.
Итак, у вас есть несколько списков сотрудников.
Ваша задача помочь получить один общий список сотрудников, но без повторов.
 */
public class Main {
    public static void main(String[] args) {

        List<Employee> teamLead1 = List.of(
                new Employee("Jack"),
                new Employee("John"),
                new Employee("Liza"),
                new Employee("Jack"),
                new Employee("Mark"));
        List<Employee> teamLead2 = List.of(
                new Employee("Jack"),
                new Employee("Mike"),
                new Employee("Nick"),
                new Employee("Mark"));
        List<Employee> teamLead3 = List.of(
                new Employee("Lena"),
                new Employee("Petr"),
                new Employee("Jack"),
                new Employee("Ann"),
                new Employee("Ivan"));

        Set<Employee> uniqEmployees = new HashSet<>();
        uniqEmployees.addAll(teamLead1);
        uniqEmployees.addAll(teamLead2);
        uniqEmployees.addAll(teamLead3);

        System.out.println("---------Новий унікальний список----------");
        for(Employee employee : uniqEmployees){
            System.out.println(employee);
        }

    }

}