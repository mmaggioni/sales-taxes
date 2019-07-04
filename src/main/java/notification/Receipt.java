package notification;

import goods.Item;
import order.Order;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Receipt {

    private Order order;

    public Receipt(Order order) {
        this.order = order;
    }

    public String print() {

        Map<Item, Long> itemsWithQuantity = order.getItemList()
                .stream()
                .collect(groupingBy(Function.identity(), Collectors.counting()));

        List<String> itemsInformationAsString = itemsWithQuantity.entrySet()
                .stream()
                .map(i -> {
                    StringBuilder sbf = new StringBuilder();
                    Item item = i.getKey();
                    Long count = i.getValue();

                    sbf.append(count + " ");
                    if (item.isImported())
                        sbf.append("imported ");

                    sbf.append(item.getName() + ": " + item.getTaxedPrice().multiply(BigDecimal.valueOf(count)).toPlainString());
                    return sbf.toString();
                }).sorted().collect(Collectors.toList());

        itemsInformationAsString.add("Sales Taxes: " + order.getSalesTaxes());
        itemsInformationAsString.add("Total: " + order.getTotal());

        StringBuilder b = new StringBuilder();
        itemsInformationAsString.forEach(item -> b.append(item).append("\n"));
        return b.toString();
    }
}
