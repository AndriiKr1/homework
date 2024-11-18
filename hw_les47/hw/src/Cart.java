import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    // Додавання товару в кошик
    public boolean addToCart(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Помилка: кількість повинна бути більшою за 0.");
            return false;
        }

        if (quantity > product.getStock()) {
            System.out.println("Помилка: неможливо додати більше товару, ніж є на складі.");
            return false;
        }

        // Оновлення кількості товару на складі
        product.setStock(product.getStock() - quantity);
        cartItems.add(new CartItem(product, quantity));
        System.out.println("Товар додано до кошика: " + product.getName() + " - " + quantity + " " + product.getUnit().getLabel());
        return true;
    }

    // Показати вміст кошика
    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Кошик порожній.");
            return;
        }

        System.out.println("Товари у вашому кошику:");
        for (CartItem item : cartItems) {
            System.out.println(item);
        }
    }

    // Підрахувати загальну суму покупки
    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (CartItem item : cartItems) {
            total = total.add(item.getTotalPrice());
        }
        return total;
    }

    // Оформити покупку
    public void checkout() {
        if (cartItems.isEmpty()) {
            System.out.println("Кошик порожній. Немає товарів для покупки.");
            return;
        }

        BigDecimal total = calculateTotal();
        System.out.println("\nЗагальна сума до сплати: " + total + " $");
        System.out.println("Дякуємо за покупку!");
        cartItems.clear();
    }
}

