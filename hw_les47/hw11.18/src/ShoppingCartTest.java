import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

public class ShoppingCartTest {

    @Test
    void testAddProductToCart() {
        Product product = new Product("Яблуко", new BigDecimal("2.0"), 8.0, 100, Unit.KILOGRAMS);
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(product, 5);
        cart.addProduct(product, 3);

        cart.displayCart();
        Assertions.assertFalse(cart.isEmpty());
    }

    @Test
    void testAddProductExceedingStock() {
        Product product = new Product("Молоко", new BigDecimal("1.2"), 8.5, 20, Unit.LITERS);
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(product, 25); // Кількість перевищує наявну
        Assertions.assertTrue(cart.isEmpty());
    }

    @Test
    void testDisplayEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        cart.displayCart();
        Assertions.assertTrue(cart.isEmpty());
    }
}

