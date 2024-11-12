import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task(1, "Fix bug", "in progress", 3);
        Task task2 = new Task(2, "Develop feature", "in progress", 7);
        Task task3 = new Task(3, "Code review", "done", 10);

        Programmer programmer1 = new Programmer("Alice", "Berlin", Arrays.asList(task1, task2));
        Programmer programmer2 = new Programmer("Bob", "Berlin", Arrays.asList(task3));

        List<Programmer> programmers = Arrays.asList(programmer1, programmer2);

        // Завдання a - Групування задач за кількістю днів обробки
        Map<Boolean, List<Task>> groupedByDays = TaskManager.groupTasksByDaysInProcessing(programmers, 5);
        System.out.println("Tasks with less than 5 days in processing: " + groupedByDays.get(true));
        System.out.println("Tasks with more than or equal to 5 days in processing: " + groupedByDays.get(false));

        // Завдання b - Групування задач за кількістю днів обробки
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        Map<Integer, List<Task>> tasksByDays = TaskManager.groupTasksByDaysInProcessing(programmers);
        tasksByDays.forEach((days, tasks) -> {
            System.out.println("Tasks processed for " + days + " days: " + tasks);
        });
    }
}
