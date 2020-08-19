package ro.jademy.carrental.enums;

public enum FuelType {
    DIESEL(5),
    GASOLINE(3),
    GPL(2),
    HYBRID(2),
    ELECTRIC(1);

    private long price;

    FuelType(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }
}
