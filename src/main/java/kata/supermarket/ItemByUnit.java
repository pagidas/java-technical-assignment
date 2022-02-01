package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemByUnit implements Item {

    private final Product product;
    private final int units;

    ItemByUnit(final Product product, int units) {
        this.product = product;
        this.units = units;
    }

    public BigDecimal price() {
        return product.getPricingOffer().getBasePricing().getPrice()
                .multiply(BigDecimal.valueOf(units))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
