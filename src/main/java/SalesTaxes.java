import goods.Item;
import notification.EmailService;
import notification.NotificationService;
import order.Order;
import order.OrderPurchaser;
import order.StandardOrderPurchaser;

import java.util.ArrayList;
import java.util.List;

public class SalesTaxes {
    public static void main(String[] args) {

        EmailService emailService = new EmailService();
        NotificationService notificationService = new NotificationService(emailService);

        OrderPurchaser orderPurchaser = new StandardOrderPurchaser(notificationService);

        List<Item> items = new ArrayList<>();

        orderPurchaser.purchase(new Order(items));

    }

    // todo review order
    // todo review receipt
    // todo review test1/2/3
}
