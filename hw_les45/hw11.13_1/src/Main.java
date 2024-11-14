import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NotCorrectEmailFormatException{


        try {
            String email = getEmail();
            System.out.println("Введений email: " + email);
        } catch (NotCorrectEmailFormatException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static String getEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть email:");
        String email = scanner.nextLine();

        // Проверка email
        if (email.length() < 5 || !email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
            throw new NotCorrectEmailFormatException("Некорректный формат email.");
        }

        return email;
    }
}
