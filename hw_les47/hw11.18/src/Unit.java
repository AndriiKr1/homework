public enum Unit {
    PIECES("шт."),
    KILOGRAMS("кг"),
    LITERS("л"),
    PACKAGES("уп");

    private final String label;

    Unit(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

