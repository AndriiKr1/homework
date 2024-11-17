import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> products = initializeProducts();
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        try {
            SortOption sortOption = getUserSortOption();
            products.sort(sortOption.getComparator());
            products.forEach(System.out::println);

            while (true) {
                System.out.println("\nВиберіть товар для додавання в кошик:");
                for (int i = 0; i < products.size(); i++) {
                    System.out.println((i + 1) + ". " + products.get(i).getName());
                }
                System.out.println("0 - Вихід");
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 0) {
                    break;
                }

                if (choice < 1 || choice > products.size()) {
                    System.out.println("Некоректний вибір, спробуйте ще раз.");
                    continue;
                }

                Product selectedProduct = products.get(choice - 1);

                System.out.println("Введіть кількість для додавання:");
                int quantity = Integer.parseInt(scanner.nextLine());

                try {
                    cart.addProduct(selectedProduct, quantity);
                    System.out.println("Товар додано в кошик.");
                } catch (InsufficientStockException e) {
                    System.out.println(e.getMessage());
                }
            }

            cart.showCart();

        } catch (UserInputException | InsufficientStockException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Невідома помилка: " + e.getMessage());
        }
    }

    public static List<Product> initializeProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Молоко", new BigDecimal("35.5"), 4, 100, MeasurementUnit.LITERS));
        products.add(new Product("Хліб", new BigDecimal("25.0"), 5, 200, MeasurementUnit.PIECES));
        products.add(new Product("Цукор", new BigDecimal("50.0"), 3, 50, MeasurementUnit.KG));
        products.add(new Product("Печиво", new BigDecimal("30.0"), 4, 150, MeasurementUnit.PACKAGES));
        return products;
    }

    public static SortOption getUserSortOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Виберіть спосіб сортування:");
        System.out.println("1 - За ціною (зростання)");
        System.out.println("2 - За ціною (спадання)");
        System.out.println("3 - За рейтингом");
        System.out.println("4 - За кількістю на складі");

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: return SortOption.BY_PRICE_ASC;
                case 2: return SortOption.BY_PRICE_DESC;
                case 3: return SortOption.BY_RATING;
                case 4: return SortOption.BY_STOCK;
                default: throw new UserInputException("Некоректний вибір.");
            }
        } catch (NumberFormatException e) {
            throw new UserInputException("Введено нечислове значення.");
        }
    }
}







