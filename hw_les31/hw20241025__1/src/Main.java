import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee(1, "Alice", 30, 3000.0),
                new Employee(2, "Bob", 25, 2500.0),
                new Employee(3, "Charlie", 35, 4000.0),
                new Employee(4, "Mike", 42, 5500.0),
                new Employee(5, "Jack", 56, 4300.0),
                new Employee(6, "John", 24, 1400.0),
                new Employee(7, "Kris", 28, 2800.0)
        };

        Arrays.sort(employees);

        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}