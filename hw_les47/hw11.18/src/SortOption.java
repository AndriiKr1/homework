import java.util.Comparator;

public enum SortOption {
    BY_TITLE("По назві", Comparator.comparing(Product::getTitle)),
    BY_PRICE("По ціні", Comparator.comparing(Product::getPrice)),
    BY_RATING("По рейтингу", Comparator.comparing(Product::getRating)),
    BY_QUANTITY("По кількості", Comparator.comparing(Product::getQuantity)),
    BY_TITLE_REVERSED("По назві (спадання)", Comparator.comparing(Product::getTitle).reversed()),
    BY_PRICE_REVERSED("По ціні (спадання)", Comparator.comparing(Product::getPrice).reversed()),
    BY_RATING_REVERSED("По рейтингу (спадання)", Comparator.comparing(Product::getRating).reversed()),
    BY_QUANTITY_REVERSED("По кількості (спадання)", Comparator.comparing(Product::getQuantity).reversed());

    private final String description;
    private final Comparator<Product> comparator;

    SortOption(String description, Comparator<Product> comparator) {
        this.description = description;
        this.comparator = comparator;
    }

    public String getDescription() {
        return description;
    }

    public Comparator<Product> getComparator() {
        return comparator;
    }
}

