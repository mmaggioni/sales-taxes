package order;

import goods.Item;
import goods.ItemCreationHelper;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class OrderTest {

    @Test
    public void test() {

        Item book = ItemCreationHelper.getBook("book", 12.49).build();
        Item cd = ItemCreationHelper.getItem("cd", 14.99).build();
        Item chocolate = ItemCreationHelper.getFood("chocolate bar", 0.85).build();

        List<Item> items = Arrays.asList(book, cd, chocolate);

        Order order = new Order(items);

        //then
//        assert order.getItemList().get(0).getTaxedPrice().toString().equals("12.49");
//        assert order.getItemList().get(1).getTaxedPrice().toString().equals("16.49");
//        assert order.getItemList().get(2).getTaxedPrice().toString().equals("0.85");

        assert order.getSalesTaxes().toString().equals("1.50");
        assert order.getTotal().toString().equals("29.83");

    }

    @Test
    public void test2() {

        Item chocolate = ItemCreationHelper.getImportedFood("box of chocolates", 10.00).build();
        Item perfume = ItemCreationHelper.getImportedItem("bottle of perfume", 47.50).build();

        List<Item> items = Arrays.asList(chocolate, perfume);
        Order order = new Order(items);

//        assert order.getItemList().get(0).getTaxedPrice().toString().equals("10.50");
//        assert order.getItemList().get(1).getTaxedPrice().toString().equals("54.65");

        assert order.getSalesTaxes().toString().equals("7.65");
        assert order.getTotal().toString().equals("65.15");

    }

    @Test
    public void test3() {

        Item importedPerfume = ItemCreationHelper.getImportedItem("bottle of perfume", 27.99).build();
        Item perfume = ItemCreationHelper.getItem("bottle of perfume", 18.99).build();
        Item pills = ItemCreationHelper.getMedicine("packet of headache pills", 9.75).build();
        Item importedChocolate = ItemCreationHelper.getImportedFood("box of chocolate", 11.25).build();

        List<Item> items = Arrays.asList(importedPerfume, perfume, pills, importedChocolate);
        Order order = new Order(items);

//        assert order.getItemList().get(0).getTaxedPrice().toString().equals("32.19");
//        assert order.getItemList().get(1).getTaxedPrice().toString().equals("20.89");
//        assert order.getItemList().get(2).getTaxedPrice().toString().equals("9.75");
//        assert order.getItemList().get(3).getTaxedPrice().toString().equals("11.85");

        assert order.getSalesTaxes().toString().equals("6.70");
        assert order.getTotal().toString().equals("74.68");

    }

}