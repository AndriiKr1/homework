/*
1.
a )  Дан список Programmer(String name, String city, List<Task>  tasks). Каждый программист  имеет список задач
           Task (int Number, String description, String status, int daysInProcessing) . Сформировать лист из всех задач.

b)  Дан список Programmer(String name, String city, List<Task>  tasks). Каждый программист  имеет список задач
       Task (int Number, String description, String status, int daysInProcessing) .
       Сформировать лист из всех задач, которые относятся к программистам из Берлина, не завершены (т.е. имеют статус, отличный от «done») и висят в обработке более 5 дней.
 */



import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Отримуємо  дані
        List<Programmer> programmers = TaskManager.createData();

        // Вивід всіх задач
        List<Task> allTasks = TaskManager.getAllTasks(programmers);
        System.out.println("Всі задачі:");
        allTasks.forEach(System.out::println);

        // Вивід задач з Берліна, які не завершені та обробляються більше 5 днів
        List<Task> berlinPendingTasks = TaskManager.getBerlinPendingTasks(programmers);
        System.out.println("\nЗадачі з Берліна, що не завершені та обробляються більше 5 днів:");
        berlinPendingTasks.forEach(System.out::println);
    }
}
