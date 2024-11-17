import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private int rating;
    private int stock;
    private MeasurementUnit unit;

    public Product(String name, BigDecimal price, int rating, int stock, MeasurementUnit unit) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.stock = stock;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public int getStock() {
        return stock;
    }

    public void decreaseStock(int quantity) {
        if (quantity > stock) {
            throw new InsufficientStockException("Недостатньо товару на складі.");
        }
        this.stock -= quantity;
    }

    public MeasurementUnit getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return String.format("Назва: %s, Ціна: %s, Рейтинг: %d, Кількість: %d %s",
                name, price, rating, stock, unit.getUnitName());
    }
}



