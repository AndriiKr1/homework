public class DHL implements MailDeliveryService {
    // Реалізуємо метод для повернення назви служби
    @Override
    public String serviceName() {
        return "DHL"; // Назва служби "DHL"
    }

    // Реалізуємо метод для відправки листа через DHL
    @Override
    public void sendMail() {
        System.out.println("Поклади лист у конверт, наклей марку, відправ.");
    }
}
