import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            System.out.println("Неможливо додати більше товару, ніж є на складі!");
            return;
        }
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }

        System.out.println("\nКорзина покупок:");
        items.forEach((product, quantity) ->
                System.out.printf("%s x%d %s\n", product.getTitle(), quantity, product.getUnit().getLabel())
        );
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}


