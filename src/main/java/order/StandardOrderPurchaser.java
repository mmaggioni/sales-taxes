package order;

import notification.NotificationService;

public class StandardOrderPurchaser implements OrderPurchaser {

    private NotificationService notificationService;
    private OrderRepository orderRepository;

    public StandardOrderPurchaser(NotificationService notificationService, OrderRepository orderRepository) {
        this.notificationService = notificationService;
        this.orderRepository = orderRepository;
    }

    public void purchase(Order order) {

        order.purchase();

        orderRepository.save(order);
        notificationService.orderPlaced(order);
    }

}
