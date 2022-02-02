package kata.supermarket;

public class Product {

    private final PricingOffer pricingOffer;

    public Product(final PricingOffer pricingOffer) {
        this.pricingOffer = pricingOffer;
    }

    public PricingOffer getPricingOffer() {
        return pricingOffer;
    }
}
