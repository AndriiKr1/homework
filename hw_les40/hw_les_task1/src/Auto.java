import java.math.BigDecimal;

public class Auto {
    private String number;
    private String brand;
    private BigDecimal price;
    private int year;

    public Auto(String number, String brand, BigDecimal price, int year) {
        this.number = number;
        this.brand = brand;
        this.price = price;
        this.year = year;
    }

    public String getNumber() {
        return number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return  "number: " + number + " " + "$" + price + " " + year +
                " " + brand ;
    }
}
