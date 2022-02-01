package kata.supermarket;

import java.math.BigDecimal;

public class Pricing {

    private final int units;
    private final BigDecimal price;

    public Pricing(int units, BigDecimal price) {
        this.units = units;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
