import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Auto> autoList = new ArrayList<>(List.of(
                new Auto("DE6592", "Toyota", new BigDecimal("19540"), 2023),
                new Auto("DE1235", "BMW", new BigDecimal("15700"), 2016),
                new Auto("DE9871", "VW", new BigDecimal("13600"), 2019),
                new Auto("DE3697", "Ford", new BigDecimal("24900"), 2022),
                new Auto("DE1111", "Mercedes", new BigDecimal("38250"), 2012)
        )
        );
        // по номеру
        autoList.sort((a1,a2) -> a1.getNumber().compareTo(a2.getNumber()));
        System.out.println("Sorted by number" + autoList);

        //по бренду
        autoList.sort((a1,a2) -> a1.getBrand().compareToIgnoreCase(a2.getBrand()));
        System.out.println("\nSorted by Brand:" + autoList);

        // по ціні
        autoList.sort((a1,a2) -> a1.getPrice().compareTo(a2.getPrice()));
        System.out.println("\nSorted by Price:" + autoList);

        // за роком випуску
        autoList.sort((a1,a2) -> Integer.compare(a1.getYear(), a2.getYear()));
        System.out.println("\nSorted by Year:" + autoList);
    }
}