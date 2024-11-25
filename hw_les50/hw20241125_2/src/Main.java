/*
Допустим, вам надо разработать систему учета рабочего времени.
Система должна хранить данные о времени прихода работника в офис и о времени выхода из офиса.
Система должна уметь посчитать
- суммарное отработанное работником время за текущий месяц
- суммарное отработанное работником время за заданный месяц
- вывести данные о переработках по дням за заданные интервал дат
- вывести данные об опозданиях по дням за заданные интервал дат

 */
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Список працівників
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Іван Іванов"));
        employees.add(new Employee(102, "Марія Петрова"));
        employees.add(new Employee(103, "Олег Коваленко"));
        employees.add(new Employee(104, "Анастасія Левченко"));
        employees.add(new Employee(105, "Дмитро Сидоренко"));
        employees.add(new Employee(106, "Оксана Руденко"));

        // Журнал відвідувань
        List<AttendanceLog> logs = new ArrayList<>();
        logs.add(new AttendanceLog(1, 101, LocalDateTime.of(2024, 11, 1, 9, 15),
                LocalDateTime.of(2024, 11, 1, 18, 0)));
        logs.add(new AttendanceLog(2, 101, LocalDateTime.of(2024, 11, 2, 8, 55),
                LocalDateTime.of(2024, 11, 2, 17, 45)));
        logs.add(new AttendanceLog(3, 101, LocalDateTime.of(2024, 11, 3, 9, 30),
                LocalDateTime.of(2024, 11, 3, 19, 0)));

        logs.add(new AttendanceLog(4, 102, LocalDateTime.of(2024, 11, 1, 8, 50),
                LocalDateTime.of(2024, 11, 1, 17, 30)));
        logs.add(new AttendanceLog(5, 102, LocalDateTime.of(2024, 11, 2, 9, 00),
                LocalDateTime.of(2024, 11, 2, 18, 00)));
        logs.add(new AttendanceLog(6, 102, LocalDateTime.of(2024, 11, 3, 9, 10),
                LocalDateTime.of(2024, 11, 3, 18, 45)));

        logs.add(new AttendanceLog(7, 103, LocalDateTime.of(2024, 11, 1, 9, 00),
                LocalDateTime.of(2024, 11, 1, 18, 30)));
        logs.add(new AttendanceLog(8, 103, LocalDateTime.of(2024, 11, 2, 9, 20),
                LocalDateTime.of(2024, 11, 2, 18, 20)));
        logs.add(new AttendanceLog(9, 103, LocalDateTime.of(2024, 11, 3, 9, 30),
                LocalDateTime.of(2024, 11, 3, 19, 15)));

        logs.add(new AttendanceLog(10, 104, LocalDateTime.of(2024, 11, 1, 9, 00),
                LocalDateTime.of(2024, 11, 1, 17, 45)));
        logs.add(new AttendanceLog(11, 104, LocalDateTime.of(2024, 11, 2, 8, 45),
                LocalDateTime.of(2024, 11, 2, 17, 15)));
        logs.add(new AttendanceLog(12, 104, LocalDateTime.of(2024, 11, 3, 9, 30),
                LocalDateTime.of(2024, 11, 3, 18, 00)));

        logs.add(new AttendanceLog(13, 105, LocalDateTime.of(2024, 11, 1, 9, 10),
                LocalDateTime.of(2024, 11, 1, 18, 00)));
        logs.add(new AttendanceLog(14, 105, LocalDateTime.of(2024, 11, 2, 8, 55),
                LocalDateTime.of(2024, 11, 2, 17, 50)));
        logs.add(new AttendanceLog(15, 105, LocalDateTime.of(2024, 11, 3, 9, 05),
                LocalDateTime.of(2024, 11, 3, 18, 40)));

        logs.add(new AttendanceLog(16, 106, LocalDateTime.of(2024, 11, 1, 9, 00),
                LocalDateTime.of(2024, 11, 1, 17, 50)));
        logs.add(new AttendanceLog(17, 106, LocalDateTime.of(2024, 11, 2, 9, 05),
                LocalDateTime.of(2024, 11, 2, 18, 10)));
        logs.add(new AttendanceLog(18, 106, LocalDateTime.of(2024, 11, 3, 9, 15),
                LocalDateTime.of(2024, 11, 3, 19, 00)));

        // Запит на введення ID працівника
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ID працівника для отримання звіту:");

        int employeeId = scanner.nextInt();
        Employee selectedEmployee = null;

        // Пошук працівника за ID
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                selectedEmployee = employee;
                break;
            }
        }

        // Якщо працівник знайдений
        if (selectedEmployee != null) {
            System.out.println("=========================================");
            System.out.println("    СИСТЕМА ОБЛІКУ РОБОЧОГО ЧАСУ");
            System.out.println("=========================================");
            System.out.printf("Працівник: %s (ID: %d)%n", selectedEmployee.getName(), selectedEmployee.getId());
            System.out.println();

            // Загальний час за поточний місяць
            Duration currentMonthTime = WorkTimeCalc.calculateTotalTimeForCurrentMonth(selectedEmployee.getId(), logs);
            System.out.println("Загальний відпрацьований час за поточний місяць:");
            System.out.printf("  - %d годин, %d хвилин%n%n",
                    currentMonthTime.toHours(), currentMonthTime.toMinutesPart());

            // Загальний час за вказаний місяць
            Duration novemberTime = WorkTimeCalc.calculateTotalTimeForMonth(selectedEmployee.getId(), logs, 2024, 11);
            System.out.println("Загальний відпрацьований час за листопад:");
            System.out.printf("  - %d годин, %d хвилин%n%n",
                    novemberTime.toHours(), novemberTime.toMinutesPart());

            // Переробки
            List<String> overtimes = WorkTimeCalc.calculateOvertimes(selectedEmployee.getId(), logs, LocalDate.of(2024, 11, 1), LocalDate.of(2024, 11, 30));
            System.out.println("Переробки за листопад:");
            if (overtimes.isEmpty()) {
                System.out.println("  - Переробок немає.");
            } else {
                overtimes.forEach(overtime -> System.out.println("  - " + overtime));
            }
            System.out.println();

            // Запізнення
            List<String> lateness = WorkTimeCalc.calculateLateness(selectedEmployee.getId(), logs, LocalDate.of(2024, 11, 1), LocalDate.of(2024, 11, 30));
            System.out.println("Запізнення за листопад:");
            if (lateness.isEmpty()) {
                System.out.println("  - Запізнень немає.");
            } else {
                lateness.forEach(late -> System.out.println("  - " + late));
            }
            System.out.println();

            System.out.println("=========================================");
            System.out.println("        КІНЕЦЬ ЗВІТУ");
            System.out.println("=========================================");
        } else {
            // Якщо працівник не знайдений
            System.out.println("Працівника з таким ID не знайдено.");
        }

        scanner.close();
    }
}

