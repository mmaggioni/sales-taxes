import goods.Item;
import goods.ItemCreationHelper;
import notification.NotificationService;
import order.Order;
import order.OrderPurchaser;
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

    @Test
    public void test() {

        OrderPurchaser orderPurchaser = new StandardOrderPurchaser(notificationService);

        Item book = ItemCreationHelper.getBook("book", 12.49).build();
        Item cd = ItemCreationHelper.getItem("cd", 14.99).build();
        Item chocolate = ItemCreationHelper.getFood("chocolate bar", 0.85).build();

        List<Item> items = Arrays.asList(book, cd, chocolate);

        Order order = new Order(items);

        // when
        orderPurchaser.purchase(order);

        //then
        assert order.isDone();
        verify(notificationService, times(1)).orderPlaced(order);

    }

    @Test
    public void test2() {

        OrderPurchaser orderPurchaser = new StandardOrderPurchaser(notificationService);

        Item chocolate = ItemCreationHelper.getImportedFood("box of chocolates", 10.00).build();
        Item perfume = ItemCreationHelper.getImportedItem("bottle of perfume", 47.50).build();

        List<Item> items = Arrays.asList(chocolate, perfume);
        Order order = new Order(items);

        // when
        orderPurchaser.purchase(order);

        //then
        assert order.isDone();
        verify(notificationService, times(1)).orderPlaced(order);

    }

    @Test
    public void test3() {

        OrderPurchaser orderPurchaser = new StandardOrderPurchaser(notificationService);

        Item importedPerfume = ItemCreationHelper.getImportedItem("bottle of perfume", 27.99).build();
        Item perfume = ItemCreationHelper.getItem("bottle of perfume", 18.99).build();
        Item pills = ItemCreationHelper.getMedicine("packet of headache pills", 9.75).build();
        Item importedChocolate = ItemCreationHelper.getImportedFood("box of chocolate", 11.25).build();

        List<Item> items = Arrays.asList(importedPerfume, perfume, pills, importedChocolate);
        Order order = new Order(items);

        // when
        orderPurchaser.purchase(order);

        //then
        assert order.isDone();
        verify(notificationService, times(1)).orderPlaced(order);

    }
}
