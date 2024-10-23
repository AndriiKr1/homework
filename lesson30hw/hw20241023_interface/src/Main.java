import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Створюємо список доступних служб доставки
        List<MailDeliveryService> services = initializeServices();

        Scanner scanner = new Scanner(System.in); // Створюємо об'єкт для введення з клавіатури
        Sender sender = new Sender();  // Створюємо об'єкт Sender для відправки листів

        displayOptions(services);  // Викликаємо метод для виведення варіантів вибору
        int select = getUserSelection(scanner, services.size()); // Отримуємо вибір користувача

        if (select < 0 || select >= services.size()) { // Перевіряємо коректність вибору
            System.out.println("Невірний вибір!"); // Якщо вибір некоректний, виводимо повідомлення
        } else {
            processSelection(services, sender, select); // Обробляємо вибір
        }
    }

    // Метод для ініціалізації списку служб доставки
    private static List<MailDeliveryService> initializeServices() {
        return List.of(new DHL(), new Email(), new Owl()); // Створюємо і повертаємо список служб
    }

    // Метод для виведення варіантів вибору на екран
    private static void displayOptions(List<MailDeliveryService> services) {
        System.out.println("Виберіть спосіб відправки листа:");
        for (int i = 0; i < services.size(); i++) {
            System.out.println(i + " - " + services.get(i).serviceName()); // Виводимо номер варіанту і назву служби
        }
    }

    // Метод для отримання вибору користувача
    private static int getUserSelection(Scanner scanner, int numberOfServices) {
        return scanner.nextInt(); // Отримуємо вибір користувача (номер служби доставки)
    }

    // Метод для обробки вибору користувача і відправки листа
    private static void processSelection(List<MailDeliveryService> services, Sender sender, int select) {
        MailDeliveryService selectedService = services.get(select); // Отримуємо вибрану службу доставки
        System.out.println("Використовується служба: " + selectedService.serviceName()); // Виводимо назву служби
        sender.send(selectedService); // Відправляємо лист через вибрану службу
    }
}


