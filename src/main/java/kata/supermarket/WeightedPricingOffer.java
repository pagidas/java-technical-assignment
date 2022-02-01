package kata.supermarket;

import java.util.Optional;

public class WeightedPricingOffer {

    private final WeightedPricing basePricing;
    private final WeightedPricing discountPricing;

    public WeightedPricingOffer(WeightedPricing basePricing, WeightedPricing discountPricing) {
        this.basePricing = basePricing;
        this.discountPricing = discountPricing;
    }

    public WeightedPricingOffer(WeightedPricing basePricing) {
        this.basePricing = basePricing;
        this.discountPricing = null;
    }

    public WeightedPricing getBasePricing() {
        return basePricing;
    }

    public Optional<WeightedPricing> getDiscountPricing() {
        return Optional.ofNullable(discountPricing);
    }
}
