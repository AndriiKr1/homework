import java.math.BigDecimal;

public class Product {
    private final String title;
    private final BigDecimal price;
    private final double rating;
    private final int quantity;
    private final Unit unit;

    public Product(String title, BigDecimal price, double rating, int quantity, Unit unit) {
        this.title = title;
        this.price = price;
        this.rating = rating;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getTitle() { return title; }
    public BigDecimal getPrice() { return price; }
    public double getRating() { return rating; }
    public int getQuantity() { return quantity; }
    public Unit getUnit() { return unit; }

    @Override
    public String toString() {
        return String.format("Назва: %s, Ціна: %.2f, Рейтинг: %.1f, Кількість: %d %s",
                title, price, rating, quantity, unit.getLabel());
    }
}
