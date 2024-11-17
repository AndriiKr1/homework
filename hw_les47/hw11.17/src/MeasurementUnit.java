public enum MeasurementUnit {
    PIECES("шт."),
    KG("кг"),
    LITERS("літрів"),
    PACKAGES("упаковок");

    private final String unitName;

    MeasurementUnit(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitName() {
        return unitName;
    }
}
