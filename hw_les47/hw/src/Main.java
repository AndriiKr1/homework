import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Молоко", new BigDecimal("1.50"), 4.5, 50, Unit.LITERS));
        products.add(new Product("Хліб", new BigDecimal("2.00"), 4.2, 150, Unit.PIECES));
        products.add(new Product("Цукор", new BigDecimal("3.00"), 4.8, 80, Unit.KG));
        products.add(new Product("Сир", new BigDecimal("6.40"), 4.9, 20, Unit.KG));
        products.add(new Product("Яйця", new BigDecimal("1.99"), 4.6, 200, Unit.PACKAGES));

        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Показати список товарів");
            System.out.println("2. Додати товар у кошик");
            System.out.println("3. Показати кошик");
            System.out.println("4. Оформити покупку");
            System.out.println("5. Вийти");

            System.out.print("Виберіть опцію: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> productService.sortAndDisplayProducts(products);
                case "2" -> productService.addProductToCart(products);
                case "3" -> productService.viewCart();
                case "4" -> productService.checkout();
                case "5" -> exit = true;
                default -> System.out.println("Неправильний вибір, спробуйте ще раз.");
            }
        }

        System.out.println("Дякуємо за використання нашого магазину!");
    }
}


