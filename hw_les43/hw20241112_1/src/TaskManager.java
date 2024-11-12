import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {

    // Метод для створення  даних
    public static List<Programmer> createData() {
        List<Task> tasks1 = Arrays.asList(
                new Task(1, "Implement feature X", "in progress", 10),
                new Task(2, "Fix bug Y", "done", 2)
        );
        List<Task> tasks2 = Arrays.asList(
                new Task(3, "Code review", "in progress", 6),
                new Task(4, "Write tests", "in progress", 7)
        );
        List<Task> tasks3 = Arrays.asList(
                new Task(5, "Update documentation", "done", 1),
                new Task(6, "Refactor code", "in progress", 8)
        );

        Programmer programmer1 = new Programmer("Max", "Berlin", tasks1);
        Programmer programmer2 = new Programmer("Anna", "Munich", tasks2);
        Programmer programmer3 = new Programmer("John", "Berlin", tasks3);

        return new ArrayList<>(Arrays.asList(programmer1, programmer2, programmer3));
    }

    // a) Метод для отримання всіх задач
    public static List<Task> getAllTasks(List<Programmer> programmers) {
        return programmers.stream()
                .flatMap(programmer -> programmer.getTasks().stream())
                .toList();
    }

    // b) Метод для фільтрації задач по місту та статусу
    public static List<Task> getBerlinPendingTasks(List<Programmer> programmers) {
        return programmers.stream()
                .filter(programmer -> programmer.getCity().equalsIgnoreCase("Berlin"))
                .flatMap(programmer -> programmer.getTasks().stream())
                .filter(task -> !task.getStatus().equalsIgnoreCase("done"))
                .filter(task -> task.getDaysInProcessing() > 5)
                .toList();
    }
}

