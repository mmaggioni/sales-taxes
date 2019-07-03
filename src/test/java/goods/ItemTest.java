package goods;

import org.junit.Test;

import java.math.BigDecimal;

public class ItemTest {

    @Test
    public void testTaxFreeItemsPrices() {

        // test books
        Item book = ItemCreationHelper.getBook("book", 12.49).build();

        assert book.getPrice().compareTo(BigDecimal.valueOf(12.49)) == 0;
        assert book.getTaxedPrice().compareTo(BigDecimal.valueOf(12.49)) == 0;

        // test food
        Item chocolate = ItemCreationHelper.getFood("chocolate bar", 0.85).build();

        assert chocolate.getPrice().compareTo(BigDecimal.valueOf(0.85)) == 0;
        assert chocolate.getTaxedPrice().compareTo(BigDecimal.valueOf(0.85)) == 0;

        // test medicine
        Item pills = ItemCreationHelper.getMedicine("packet of headache pills", 123.99).build();

        assert pills.getPrice().compareTo(BigDecimal.valueOf(123.99)) == 0;
        assert pills.getTaxedPrice().compareTo(BigDecimal.valueOf(123.99)) == 0;

    }

    @Test
    public void testNormalItemsPrices() {
        Item cd = ItemCreationHelper.getItem("cd", 14.99).build();

        assert cd.getPrice().compareTo(BigDecimal.valueOf(14.99)) == 0;
        assert cd.getTaxedPrice().compareTo(BigDecimal.valueOf(16.49)) == 0;
    }

    @Test
    public void testImportedItemsPrices() {

        // test tax free items
        Item chocolate = ItemCreationHelper.getImportedFood("box of chocolates", 10.00).build();

        assert chocolate.getPrice().compareTo(BigDecimal.valueOf(10.00)) == 0;
        assert chocolate.getTaxedPrice().compareTo(BigDecimal.valueOf(10.50)) == 0;

        // test normal items
        Item perfume = ItemCreationHelper.getImportedItem("bottle of perfume", 47.50).build();

        assert perfume.getPrice().compareTo(BigDecimal.valueOf(47.50)) == 0;
        assert perfume.getTaxedPrice().compareTo(BigDecimal.valueOf(54.65)) == 0;
    }

}