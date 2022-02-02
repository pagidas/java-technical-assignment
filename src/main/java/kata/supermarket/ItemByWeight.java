package kata.supermarket;

import kata.supermarket.discount.DiscountVisitor;
import kata.supermarket.discount.Discountable;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemByWeight implements Item, Discountable<BigDecimal> {

    private final WeightedProduct product;
    private final BigDecimal weightInKilos;

    ItemByWeight(final WeightedProduct product, final BigDecimal weightInKilos) {
        this.product = product;
        this.weightInKilos = weightInKilos;
    }

    public WeightedProduct getProduct() {
        return product;
    }

    public BigDecimal getWeightInKilos() {
        return weightInKilos;
    }

    public BigDecimal price() {
        return product.getPricingOffer().getBasePricing().getPrice()
                .multiply(weightInKilos)
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal discount(DiscountVisitor<BigDecimal> visitor) {
        return visitor.calculate(this);
    }
}
