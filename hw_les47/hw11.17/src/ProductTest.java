import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;



public class ProductTest {

    @Test
    void testDecreaseStock() {
        Product product = new Product("Молоко", new BigDecimal("35.5"), 4, 100, MeasurementUnit.LITERS);
        product.decreaseStock(10);
        Assertions.assertEquals(90, product.getStock());
    }

    @Test
    void testDecreaseStockThrowsException() {
        Product product = new Product("Хліб", new BigDecimal("25.0"), 5, 10, MeasurementUnit.PIECES);
        Assertions.assertThrows(InsufficientStockException.class, () -> product.decreaseStock(15));
    }
}
