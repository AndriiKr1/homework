/*

Руководство компании решило премировать сотрудников. Каждый team lead подал список сотрудников для получения премии.
Но получилось так, что некоторые сотрудники работают на нескольких проектах и попали в списки несколько раз. Для таких сотрудников решено увеличить премию.
Итак, у вас есть несколько списков сотрудников. Ваша задача получить Map<Employee, Integer> где ключем будет сотрудник, а значением, сколько раз он встретился в списках.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        List<Employee> team1 = List.of(new Employee("Jack"), new Employee("Nick"), new Employee("Mike"));
        List<Employee> team2 = List.of(new Employee("Jack"), new Employee("Nick"), new Employee("Lena"));
        List<Employee> team3 = List.of(new Employee("Jack"), new Employee("Ann"));

        List<List<Employee>> listsOfEmployees = List.of(team1, team2, team3);


        Map<Employee, Integer> employeeCountMap = countEmployeeOccurrences(listsOfEmployees);

        System.out.println("Количество встреч каждого сотрудника в листе:");
        for (Map.Entry<Employee, Integer> entry : employeeCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());

        }
    }

    public static Map<Employee, Integer> countEmployeeOccurrences(List<List<Employee>> listsOfEmployees) {
        Map<Employee, Integer> employeeCountMap = new HashMap<>();


        for (List<Employee> teamList : listsOfEmployees) {
            for (Employee employee : teamList) {

                employeeCountMap.put(employee, employeeCountMap.getOrDefault(employee, 0) + 1);

            }
        }
        return employeeCountMap;
    }

}