package notification;

import goods.Item;
import order.Order;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ReceiptTest {

    @Test
    public void print() {

        Item importedPerfume = new Item.Builder("bottle of perfume", 27.99).imported().build();
        Item perfume = new Item.Builder("bottle of perfume", 18.99).build();
        Item pills = new Item.Builder("packet of headache pills", 9.75).type(Item.Type.MEDICAL).build();
        Item importedChocolate = new Item.Builder("box of chocolate", 11.25).type(Item.Type.FOOD).imported().build();

        List<Item> items = Arrays.asList(importedPerfume, perfume, pills, importedChocolate, importedPerfume);

        Receipt receipt = new Receipt(new Order(items));

        assert receipt.print().equals(
                "1 bottle of perfume: 20.89\n"+
                "1 imported box of chocolate: 11.85\n"+
                "1 packet of headache pills: 9.75\n"+
                "2 imported bottle of perfume: 64.38\n"+
                "Sales Taxes: 10.90\n"+
                "Total: 106.87\n");
    }
}