package ro.jademy.carrental.enums;

public enum Color {
    RED(10),
    BLACK(15),
    MAROON(8),
    YELLOW(13),
    GREY(7),
    GREEN(10),
    BLUE(12),
    WHITE(15);

    private long price;

    Color(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }
}
