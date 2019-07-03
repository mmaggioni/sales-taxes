package notification;

import order.Order;

public class NotificationService {

    private EmailService emailService;

    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void orderPlaced(Order order) {
        Receipt receipt = new Receipt(order);

        emailService.sendReceipt(receipt);
    }
}
