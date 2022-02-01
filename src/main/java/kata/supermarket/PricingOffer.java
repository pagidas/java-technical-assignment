package kata.supermarket;

import java.util.Optional;

public class PricingOffer {

    private final Pricing basePricing;
    private final Pricing discountPricing;

    public PricingOffer(Pricing basePricing, Pricing discountPricing) {
        this.basePricing = basePricing;
        this.discountPricing = discountPricing;
    }

    public PricingOffer(Pricing basePricing) {
        this.basePricing = basePricing;
        this.discountPricing = null;
    }

    public Pricing getBasePricing() {
        return basePricing;
    }

    public Optional<Pricing> getDiscountPricing() {
        return Optional.ofNullable(discountPricing);
    }
}
