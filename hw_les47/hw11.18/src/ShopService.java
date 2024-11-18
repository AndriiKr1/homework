import java.util.List;
import java.util.Scanner;

public class ShopService {

    public static void runShop(List<Product> products, ShoppingCart cart) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nМеню:");
            System.out.println("1. Показати товари");
            System.out.println("2. Сортувати товари");
            System.out.println("3. Додати товар у корзину");
            System.out.println("4. Показати корзину");
            System.out.println("5. Завершити покупку");
            System.out.println("0. Вихід");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    printProducts(products);
                    break;
                case "2":
                    sortAndDisplayProducts(products);
                    break;
                case "3":
                    addProductToCart(products, cart);
                    break;
                case "4":
                    cart.displayCart();
                    break;
                case "5":
                    finalizePurchase(cart);
                    running = false;
                    break;
                case "0":
                    running = false;
                    System.out.println("До побачення!");
                    break;
                default:
                    System.out.println("Некоректний вибір.");
            }
        }
    }

    private static void printProducts(List<Product> products) {
        products.forEach(System.out::println);
    }

    private static void sortAndDisplayProducts(List<Product> products) {
        SortOption sortOption = selectSortType();
        if (sortOption != null) {
            products.stream().sorted(sortOption.getComparator()).forEach(System.out::println);
        }
    }

    private static SortOption selectSortType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Виберіть тип сортування:");
        for (int i = 0; i < SortOption.values().length; i++) {
            System.out.printf("%d. %s\n", i + 1, SortOption.values()[i].getDescription());
        }
        System.out.println("0. Відміна");
        int choice = Integer.parseInt(scanner.nextLine());
        return (choice > 0 && choice <= SortOption.values().length) ? SortOption.values()[choice - 1] : null;
    }

    private static void addProductToCart(List<Product> products, ShoppingCart cart) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть назву товару: ");
        String productName = scanner.nextLine();
        Product product = products.stream()
                .filter(p -> p.getTitle().equalsIgnoreCase(productName))
                .findFirst()
                .orElse(null);

        if (product != null) {
            System.out.print("Кількість: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            cart.addProduct(product, quantity);
        } else {
            System.out.println("Товар не знайдено.");
        }
    }

    private static void finalizePurchase(ShoppingCart cart) {
        if (!cart.isEmpty()) {
            System.out.println("Дякуємо за покупку!");
            cart.displayCart();
        } else {
            System.out.println("Корзина пуста.");
        }
    }
}
