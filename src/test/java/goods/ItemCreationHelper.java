package goods;

public class ItemCreationHelper {

    public static Item.Builder getBook(String name, double price) {
        return getItem(name, price)
                .type(Item.Type.BOOK);
    }

    public static Item.Builder getImportedBook(String name, double price) {
        return getBook(name, price).imported();
    }

    public static Item.Builder getFood(String name, double price) {
        return getItem(name, price)
                .type(Item.Type.FOOD);
    }

    public static Item.Builder getImportedFood(String name, double price) {
        return getFood(name, price).imported();
    }

    public static Item.Builder getMedicine(String name, double price) {
        return getItem(name, price)
                .type(Item.Type.MEDICAL);
    }

    public static Item.Builder getImportedMedicine(String name, double price) {
        return getMedicine(name, price).imported();
    }

    public static Item.Builder getItem(String name, double price) {
        return new Item.Builder(name, price);
    }

    public static Item.Builder getImportedItem(String name, double price) {
        return getItem(name, price).imported();
    }
}
