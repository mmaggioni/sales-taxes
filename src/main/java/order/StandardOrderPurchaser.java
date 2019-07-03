package order;

import notification.NotificationService;

public class StandardOrderPurchaser implements OrderPurchaser {

    private NotificationService notificationService;

    public StandardOrderPurchaser(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void purchase(Order order) {

        // code to purchase the order
        // ...
        order.purchase();
        // do other stuff, then save


        notificationService.orderPlaced(order);
    }

}
