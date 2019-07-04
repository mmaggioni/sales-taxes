import goods.Item;
import notification.EmailService;
import notification.NotificationService;
import order.Order;
import order.OrderPurchaser;
import order.OrderRepository;
import order.StandardOrderPurchaser;

import java.util.Arrays;
import java.util.List;

public class SalesTaxes {

    public static void main(String[] args) {

        EmailService emailService = new EmailService();
        NotificationService notificationService = new NotificationService(emailService);

        OrderRepository orderRepository = new OrderRepository();
        OrderPurchaser orderPurchaser = new StandardOrderPurchaser(notificationService, orderRepository);

        orderPurchaser.purchase(getOrder());

    }

    private static Order getOrder() {

        Item importedPerfume = new Item.Builder("bottle of perfume", 27.99).imported().build();
        Item perfume = new Item.Builder("bottle of perfume", 18.99).build();
        Item pills = new Item.Builder("packet of headache pills", 9.75).type(Item.Type.MEDICAL).build();
        Item importedChocolate = new Item.Builder("box of chocolate", 11.25).type(Item.Type.FOOD).imported().build();

        List<Item> items = Arrays.asList(importedPerfume, perfume, pills, importedChocolate, importedPerfume);
        return new Order(items);
    }

}
