import java.util.Comparator;

public enum SortOption {
    PRICE_ASC("Ціна за зростанням", Comparator.comparing(Product::getPrice)),
    PRICE_DESC("Ціна за спаданням", Comparator.comparing(Product::getPrice).reversed()),
    RATING_DESC("Рейтинг за спаданням", Comparator.comparing(Product::getRating).reversed()),
    STOCK_DESC("Кількість на складі за спаданням", Comparator.comparing(Product::getStock).reversed());

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


