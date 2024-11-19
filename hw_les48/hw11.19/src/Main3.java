import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        String fileName = "persons.txt";
        List<Person> persons = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String s;
            while ((s = reader.readLine()) != null) {
                String[] parts = s.split("[,;]");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int age = Integer.parseInt(parts[1].trim());
                    persons.add(new Person(name, age));
                }
            }
        } catch (IOException e) {
            System.out.println("Сталася помилка під час читання файлу: ");
        } catch (NumberFormatException e) {
            System.out.println("Помилка формату числа: " );
        }


        System.out.println("Список людей:");
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}