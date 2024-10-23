/*
# 3 Чуть сложнее
  Допустим, мы пишем программу для онлайн магазина.
  Программа выводит на экран список товаров (каждый товар имеет номер, название и цену).
  Пользователь, используя сканнер вводит номера товаров, тем самым добавляя их к себе в корзину.
  Как только пользователь заканчивает ввод (например , вместо номера товара вводит 0) программа выдает список покупок.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Телевізор", 400));
        products.add(new Product(2, "Ноутбук", 1300));
        products.add(new Product(3, "Телефон", 250));
        products.add(new Product(4, "Годинник", 80));


        System.out.println("Список товарів: ");
        for (Product product : products) {
            System.out.println(product);
        }

        List<Product> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nВведіть номер товару,щоб добавити його в кошик або '0' для завершення роботи");

        while (true) {
            System.out.println("Введіть номер товару: ");
            int prodId = scanner.nextInt();

            if (prodId == 0) {
                break;
            }
Product selectedProduct = null;
            for (Product product : products) {
                if (product.getId() == prodId){
                    selectedProduct=product;
                    break;
                }
            }
            if (selectedProduct != null){
                list.add(selectedProduct);
                System.out.println(selectedProduct.getName()+ " добавлений в кошик.");
            } else {
                System.out.println("Товар з таким номером не знайдено");
            }
        }
        System.out.println("\nВаш список покупок: ");
        if (list.isEmpty()){
            System.out.println("Ваш кошик пустий.");
        }else {
            for (Product product : list){
                System.out.println(product);
            }
        }
    }
}