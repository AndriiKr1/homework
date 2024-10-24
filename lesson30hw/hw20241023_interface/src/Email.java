public class Email implements MailDeliveryService {
    // Реалізуємо метод для повернення назви служби
    @Override
    public String serviceName() {
        return "E-Mail"; // Назва служби "E-Mail"
    }

    // Реалізуємо метод для відправки листа через E-Mail
    @Override
    public void sendMail() {
        System.out.println("Відправити через Інтернет.");
    }
}
