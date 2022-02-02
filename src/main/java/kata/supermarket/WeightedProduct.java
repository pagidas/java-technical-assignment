package kata.supermarket;

public class WeightedProduct {

    private final WeightedPricingOffer weightedPricingOffer;

    public WeightedProduct(WeightedPricingOffer weightedPricingOffer) {
        this.weightedPricingOffer = weightedPricingOffer;
    }

    public WeightedPricingOffer getPricingOffer() {
        return weightedPricingOffer;
    }
}
