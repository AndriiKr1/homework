public interface MailDeliveryService {
    // Метод для отримання назви служби доставки
   public String serviceName();

    // Метод для відправки листа
    void sendMail();
}

