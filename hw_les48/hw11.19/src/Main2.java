import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        String fileName = "names.txt";
        Set<String> uniqueNames = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                uniqueNames.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Сталася помилка під час запису у файл: ");
        }

        // Вывод уникальных имен
        System.out.println("Унікальні імена:");
        for (String name : uniqueNames) {
            System.out.println(name);
        }
    }
}
