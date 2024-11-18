import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

public class ProductTest {

    @Test
    void testProductCreation() {
        Product product = new Product("Банан", new BigDecimal("1.50"), 9.0, 50, Unit.KILOGRAMS);
        Assertions.assertEquals("Банан", product.getTitle());
        Assertions.assertEquals(new BigDecimal("1.50"), product.getPrice());
        Assertions.assertEquals(9.0, product.getRating());
        Assertions.assertEquals(50, product.getQuantity());
        Assertions.assertEquals(Unit.KILOGRAMS, product.getUnit());
    }

    @Test
    void testProductToString() {
        Product product = new Product("Молоко", new BigDecimal("0.99"), 8.5, 30, Unit.LITERS);
        String expected = "Назва: Молоко, Ціна: 0,99, Рейтинг: 8,5, Кількість: 30 л";
        Assertions.assertEquals(expected, product.toString());
    }
}
