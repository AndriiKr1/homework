import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import java.math.BigDecimal;
import java.util.List;

public class ShopServiceTest {

    private final List<Product> testProducts = List.of(
            new Product("Ананас", new BigDecimal("3.0"), 5.0, 30, Unit.PIECES),
            new Product("Банан", new BigDecimal("1.5"), 7.0, 50, Unit.KILOGRAMS),
            new Product("Апельсин", new BigDecimal("2.5"), 8.0, 40, Unit.KILOGRAMS)
    );

    @ParameterizedTest
    @EnumSource(value = SortOption.class, names = {"BY_TITLE", "BY_TITLE_REVERSED"})
    void testSortByTitle(SortOption option) {
        List<Product> sortedProducts = testProducts.stream()
                .sorted(option.getComparator())
                .toList();

        if (option == SortOption.BY_TITLE) {
            Assertions.assertEquals("Ананас", sortedProducts.get(0).getTitle());
            Assertions.assertEquals("Апельсин", sortedProducts.get(1).getTitle());
            Assertions.assertEquals("Банан", sortedProducts.get(2).getTitle());
        } else {
            Assertions.assertEquals("Банан", sortedProducts.get(0).getTitle());
            Assertions.assertEquals("Апельсин", sortedProducts.get(1).getTitle());
            Assertions.assertEquals("Ананас", sortedProducts.get(2).getTitle());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "BY_PRICE, Банан, Апельсин, Ананас",
            "BY_PRICE_REVERSED, Ананас, Апельсин, Банан",
            "BY_RATING, Ананас, Банан, Апельсин",
            "BY_QUANTITY, Ананас, Апельсин, Банан"
    })
    void testSortingByDifferentOptions(String sortOption, String first, String second, String third) {
        SortOption option = SortOption.valueOf(sortOption);
        List<Product> sortedProducts = testProducts.stream()
                .sorted(option.getComparator())
                .toList();

        Assertions.assertEquals(first, sortedProducts.get(0).getTitle());
        Assertions.assertEquals(second, sortedProducts.get(1).getTitle());
        Assertions.assertEquals(third, sortedProducts.get(2).getTitle());
    }
}
