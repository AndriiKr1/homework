
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskManager {

    // Метод для створення мапи, де ключ true - задачі з обробкою менше заданих днів
    public static Map<Boolean, List<Task>> groupTasksByDaysInProcessing(List<Programmer> programmers, int maxDays) {
        return programmers.stream()
                .flatMap(programmer -> programmer.getTasks().stream())
                .collect(Collectors.groupingBy(
                        task -> task.getDaysInProcessing() < maxDays
                ));
    }

    // Метод для групування задач по кількості днів обробки
    public static Map<Integer, List<Task>> groupTasksByDaysInProcessing(List<Programmer> programmers) {
        return programmers.stream()
                .flatMap(programmer -> programmer.getTasks().stream())
                .collect(Collectors.groupingBy(Task::getDaysInProcessing));
    }


}
