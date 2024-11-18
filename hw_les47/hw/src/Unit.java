public enum Unit {
    PIECES("шт"),
    KG("кг"),
    LITERS("л"),
    PACKAGES("упаковки");

    private final String label;

    Unit(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}


