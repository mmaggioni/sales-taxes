import goods.Item;
import goods.ItemCreationHelper;
import notification.NotificationService;
import order.Order;
import order.OrderPurchaser;
import order.OrderRepository;
import order.StandardOrderPurchaser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class PurchaseTest {

    @Mock
    NotificationService notificationService;

    @Mock
    OrderRepository orderRepository;

    @Test
    public void testAnOrderPurchase() {

        OrderPurchaser orderPurchaser = new StandardOrderPurchaser(notificationService, orderRepository);

        Item book = ItemCreationHelper.getBook("book", 12.49).build();
        List<Item> items = Arrays.asList(book);

        Order order = new Order(items);

        // when
        orderPurchaser.purchase(order);

        //then the order is set to "done", is saved and the notification services is notified
        assert order.isDone();
        verify(orderRepository, times(1)).save(order);
        verify(notificationService, times(1)).orderPlaced(order);

    }

}
