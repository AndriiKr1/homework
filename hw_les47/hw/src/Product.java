import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private double rating;
    private int stock;
    private Unit unit;

    public Product(String name, BigDecimal price, double rating, int stock, Unit unit) {
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

    public double getRating() {
        return rating;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Unit getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return String.format("%s - ціна: %.2f $, рейтинг: %.1f, на складі: %d %s",
                name, price, rating, stock, unit.getLabel());
    }
}

