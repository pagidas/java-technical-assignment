package kata.supermarket;

import java.math.BigDecimal;

public class WeightedProduct {

    private final WeightedPricingOffer weightedPricingOffer;

    public WeightedProduct(WeightedPricingOffer weightedPricingOffer) {
        this.weightedPricingOffer = weightedPricingOffer;
    }

    public WeightedPricingOffer getPricingOffer() {
        return weightedPricingOffer;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }
}
