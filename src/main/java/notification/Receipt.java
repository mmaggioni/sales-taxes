package notification;

import goods.Item;
import order.Order;

import java.math.BigDecimal;
import java.util.List;

public class Receipt {

    private Order order;

    public Receipt(Order order) {
        this.order = order;
    }

    public List<Item> listItems() {
        return this.order.getItemList();
    }

    public BigDecimal getSalesTaxes() {
        return order.getSalesTaxes();
    }

    public BigDecimal getTotal() {
        return order.getTotal();
    }

    @Override
    public String toString() {
        // todo
        return super.toString();
    }
}
