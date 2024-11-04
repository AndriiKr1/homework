public class Owl implements MailDeliveryService {
    // Реалізуємо метод для повернення назви служби
    @Override
    public String serviceName() {
        return "Сова"; // Назва служби "Сова"
    }

    // Реалізуємо метод для відправки листа через сову
    @Override
    public void sendMail() {
        System.out.println("Привіт Гаррі Поттер!");
    }
}
