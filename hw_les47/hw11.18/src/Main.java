import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Банан", new BigDecimal("1.4"), 8.3, 100, Unit.KILOGRAMS),
                new Product("Апельсин", new BigDecimal("1.8"), 7.5, 80, Unit.KILOGRAMS),
                new Product("Молоко", new BigDecimal("0.99"), 8.7, 30, Unit.LITERS),
                new Product("Яблуко", new BigDecimal("2.2"), 9.1, 70, Unit.KILOGRAMS),
                new Product("Ананас", new BigDecimal("3.4"), 6.1, 70, Unit.PIECES),
                new Product("Печиво", new BigDecimal("3.4"), 9.2,50, Unit.PACKAGES)
        );

        ShoppingCart cart = new ShoppingCart();
        ShopService.runShop(products, cart);
    }
}


