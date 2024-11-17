import java.util.Comparator;

public enum SortOption {
    BY_PRICE_ASC(Comparator.comparing((Product product) -> product.getPrice())),
    BY_PRICE_DESC((product1, product2) -> product2.getPrice().compareTo(product1.getPrice())),
    BY_RATING((product1, product2) -> Integer.compare(product2.getRating(), product1.getRating())),
    BY_STOCK((product1, product2) -> Integer.compare(product2.getStock(), product1.getStock()));

    private final Comparator<Product> comparator;

    SortOption(Comparator<Product> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Product> getComparator() {
        return comparator;
    }
}



