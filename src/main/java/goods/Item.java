package goods;

import utils.Utils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Item {

    private String name;
    private BigDecimal price;
    private double taxPercentage = 10;
    private Type type = Type.OTHER;
    private Boolean imported;

    public enum Type {
        BOOK,
        MEDICAL,
        FOOD,
        OTHER;

        public boolean isTaxFree() {
            return getTaxFreeTypes().contains(this);
        }

        public List<Type> getTaxFreeTypes() {
            return Arrays.asList(BOOK, MEDICAL, FOOD);
        }
    }

    public String getName() {
        return name;
    }

    public boolean isImported() {
        return imported;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTaxedPrice() {
        if (taxPercentage == 0)
            return price;
        else
            return price.add(
                    Utils.roundToTheNearest5Cent(price.multiply(BigDecimal.valueOf(taxPercentage / 100)))
            );
    }

    public static class Builder {

        private String name;
        private BigDecimal price;
        private double taxPercentage = 10;
        private boolean imported = false;
        private Type type = Type.OTHER;

        public Builder(String name, BigDecimal price) {
            this.price = price;
            this.name = name;
        }

        public Builder(String name, Double price) {
            this.price = BigDecimal.valueOf(price);
            this.name = name;
        }

        public Builder imported() {
            this.imported = true;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Item build() {
            Item item = new Item();
            item.name = name;
            item.price = price;
            item.type = type;

            if (type.isTaxFree()) {
                item.taxPercentage = 0;
                taxPercentage = 0;
            } else {
                item.taxPercentage = taxPercentage;
            }

            item.imported = imported;

            if (imported)
                item.taxPercentage = item.taxPercentage + 5;

            return item;
        }
    }
}
