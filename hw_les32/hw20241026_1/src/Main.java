import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<> (List.of(
                new Product("Laptop", 1200, 4.5, 15),
                new Product("Smartphone", 800, 4.7, 25),
                new Product("Headphones", 150, 4.2, 100),
                new Product("Monitor", 300, 4.4, 30)
        ));


        System.out.println(productsList);
    }

}