import java.util.List;
import java.util.Scanner;

public class ProductService {
    private Cart cart = new Cart();

    public void sortAndDisplayProducts(List<Product> products) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        int choice = -1;

        // Вибір сортування
        while (!validInput) {
            System.out.println("Виберіть опцію сортування:");
            for (int i = 0; i < SortOption.values().length; i++) {
                System.out.println((i + 1) + ". " + SortOption.values()[i].getDescription());
            }

            System.out.print("Введіть номер опції: ");
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= 1 && choice <= SortOption.values().length) {
                    validInput = true;
                } else {
                    System.out.println("Помилка: введіть номер від 1 до " + SortOption.values().length + ".\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Помилка вводу: введіть ціле число.\n");
            }
        }

        // Сортування та вивід товарів
        SortOption selectedOption = SortOption.values()[choice - 1];
        products.sort(selectedOption.getComparator());

        System.out.println("\nВідсортований список товарів:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
    }

    // Додавання товару в кошик
    public void addProductToCart(List<Product> products) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nВведіть номер товару для додавання в кошик: ");
        try {
            int productIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
            if (productIndex < 0 || productIndex >= products.size()) {
                System.out.println("Помилка: неправильний номер товару.");
                return;
            }

            Product selectedProduct = products.get(productIndex);

            System.out.print("Введіть кількість для додавання в кошик: ");
            int quantity = Integer.parseInt(scanner.nextLine().trim());

            cart.addToCart(selectedProduct, quantity);

        } catch (NumberFormatException e) {
            System.out.println("Помилка вводу: введіть ціле число.");
        }
    }

    public void viewCart() {
        cart.displayCart();
    }

    public void checkout() {
        cart.checkout();
    }
}





