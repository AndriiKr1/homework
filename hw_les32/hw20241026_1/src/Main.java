import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Ініціалізація списку продуктів за допомогою ArrayList та List.of для створення початкових значень
        List<Product> productsList = new ArrayList<>(List.of(
                new Product("Laptop", 1200, 4.5, 15),
                new Product("Smartphone", 800, 4.7, 25),
                new Product("Headphones", 150, 4.2, 100),
                new Product("Monitor", 300, 4.4, 30),
                new Product("Keyboard", 50, 4.6, 75),
                new Product("Mouse", 25, 4.8, 150),
                new Product("External Hard Drive", 100, 4.5, 40),
                new Product("Webcam", 70, 4.3, 60)
        ));
        //System.out.println(productsList);
        int choice = getSortChoice(); // Виклик методу getSortChoice для отримання вибору сортування від користувача

        sortProducts(productsList, choice); // Виклик методу sortProducts для сортування списку продуктів на основі вибору користувача
        printSortProduct(productsList); // Виклик методу printSortProduct для відображення відсортованого списку продуктів
    }

    // Метод для запиту у користувача критерію сортування
    public static int getSortChoice() {
        Scanner scanner = new Scanner(System.in); // Створення об'єкта Scanner для зчитування введення з консолі
        System.out.println("Як ви хочете сортувати продукти?");
        System.out.println("1. По ціні зростання");
        System.out.println("2. По ціні спадання");
        System.out.println("3. По рейтингу");
        System.out.println("4. По залишкам на складі");
        return scanner.nextInt(); // Повернення вибору користувача (число від 1 до 4)
    }

    // Метод для сортування продуктів на основі вибраного критерію
    public static void sortProducts(List<Product> productsList, int choice) {
        // Створення масиву компараторів для різних критеріїв сортування
        Comparator<Product>[] comparators = new Comparator[]{
                new ComparatorProductByPriceAscendig(), // Порівняння по ціні за зростанням
                new ComparatorProductByPriceDescending(), // Порівняння по ціні за спаданням
                new ComparatorProductByRating(), // Порівняння по рейтингу
                new ComparatorProductByStock() // Порівняння по кількості на складі
        };
        // Перевірка, що вибір користувача знаходиться в межах допустимого діапазону
        if (choice >= 1 && choice <= comparators.length) {
            productsList.sort(comparators[choice - 1]); // Сортування списку продуктів за допомогою вибраного компаратора
        } else {
            System.out.println("Невірний вибір!"); // Повідомлення про помилку, якщо вибір недійсний
        }
    }

    // Метод для виводу відсортованого списку продуктів
    public static void printSortProduct(List<Product> productsList) {
        System.out.println("Відсортований список товарів: "); // Заголовок для відсортованого списку
        for (Product result : productsList) { // Цикл по всім продуктам у списку
            System.out.println(result); // Вивід кожного продукту на консоль
        }
    }
}
