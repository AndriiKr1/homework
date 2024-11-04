public class Sender {
    // Метод send приймає об'єкт типу MailDeliveryService і викликає його метод sendMail()
    public void send(MailDeliveryService service) {
        service.sendMail(); // Викликаємо метод для відправки листа через вибрану службу доставки
    }
}

