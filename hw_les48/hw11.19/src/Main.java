import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ваше ім'я: ");
        String name = scanner.nextLine();

        System.out.print("Введіть ваш вік: ");
        int age = scanner.nextInt();

        try (FileWriter writer = new FileWriter("name.txt")) {
            writer.write("Ім'я: " + name + "\n");
            writer.write("Вік: " + age + "\n");
            System.out.println("Інформацію успішно записано у файл name.txt");
        } catch (IOException e) {
            System.out.println("Сталася помилка під час запису у файл: ");
        }
    }
}