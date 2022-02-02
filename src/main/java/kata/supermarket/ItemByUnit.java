package kata.supermarket;

import kata.supermarket.discount.DiscountVisitor;
import kata.supermarket.discount.Discountable;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemByUnit implements Item, Discountable<BigDecimal> {

    private final Product product;
    private final int units;

    ItemByUnit(final Product product, int units) {
        this.product = product;
        this.units = units;
    }

    public Product getProduct() {
        return product;
    }

    public int getUnits() {
        return units;
    }

    public BigDecimal price() {
        return product.getPricingOffer().getBasePricing().getPrice()
                .multiply(BigDecimal.valueOf(units))
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal discount(DiscountVisitor<BigDecimal> visitor) {
        return visitor.calculate(this);
    }
}
