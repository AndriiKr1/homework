import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        if (product.getStock() < quantity) {
            throw new InsufficientStockException("Недостатньо товару на складі: " + product.getName());
        }

        product.decreaseStock(quantity);

        items.put(product, items.getOrDefault(product, 0) + quantity);
    }


    public void showCart() {
        System.out.println("Кошик покупця:");
        if (items.isEmpty()) {
            System.out.println("Ваш кошик порожній.");
        } else {
            items.forEach((product, quantity) ->
                    System.out.println(product.getName() + " - " + quantity + " шт."));
        }
    }

    public Map<Product, Integer> getItems() {
        return items;
    }
}



