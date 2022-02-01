package kata.supermarket;

import java.math.BigDecimal;

public class WeightedPricing {

    private final BigDecimal unitsInKilos;
    private final BigDecimal price;

    public WeightedPricing(BigDecimal unitsInKilos, BigDecimal price) {
        this.unitsInKilos = unitsInKilos;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
