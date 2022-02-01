package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemByWeight implements Item {

    private final WeightedProduct product;
    private final BigDecimal weightInKilos;

    ItemByWeight(final WeightedProduct product, final BigDecimal weightInKilos) {
        this.product = product;
        this.weightInKilos = weightInKilos;
    }

    public BigDecimal price() {
        return product.getPricingOffer().getBasePricing().getPrice()
                .multiply(weightInKilos)
                .setScale(2, RoundingMode.HALF_UP);
    }
}
