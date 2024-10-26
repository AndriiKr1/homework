
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("John", List.of(7, 8, 9)),
                new Student("Alice", List.of(8, 9, 7)),
                new Student("Bob", List.of(6, 7, 7)),
                new Student("Nick", List.of(6, 7, 7)),
        };

        // Сортування студентів за середнім значенням оцінок за допомогою Comparable
        Arrays.sort(students);

        // Виведення відсортованого списку студентів
        for (Student student : students) {
            System.out.println(student);
        }
    }
}