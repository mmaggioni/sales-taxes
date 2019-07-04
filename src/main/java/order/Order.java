package order;

import goods.Item;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private List<Item> itemList;
    private Status orderStatus = Status.NEW;

    private enum Status {
        NEW,
        DONE
    }

    public Order(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public BigDecimal getTotal() {
        return itemList
                .stream()
                .map(Item::getTaxedPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalWithoutTax() {
        return itemList
                .stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getSalesTaxes() {
        return getTotal().subtract(getTotalWithoutTax());
    }

    public void purchase() {
        orderStatus = Status.DONE;
    }

    public boolean isDone() {
        return orderStatus == Status.DONE;
    }

}
