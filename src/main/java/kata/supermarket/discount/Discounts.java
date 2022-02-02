package kata.supermarket.discount;

import kata.supermarket.ItemByUnit;
import kata.supermarket.ItemByWeight;

import java.math.BigDecimal;
import java.util.function.Function;

class Discounts {

    static final Function<Object, BigDecimal> itemByUnitDiscount = item -> {
        var itemByUnit = (ItemByUnit) item;

        if (discountNotApplicable(itemByUnit)) return BigDecimal.ZERO;

        var basePricing = itemByUnit.getProduct().getPricingOffer().getBasePricing();
        var discountPricing = itemByUnit.getProduct().getPricingOffer().getDiscountPricing().orElseThrow();

        var totalPrice = BigDecimal.valueOf(itemByUnit.getUnits()).multiply(basePricing.getPrice());
        var basalPricedRemainder = itemByUnit.getUnits() % discountPricing.getUnits();
        var applyDiscountCount = itemByUnit.getUnits() / discountPricing.getUnits();

        var discountedPrice = discountPricing.getPrice().multiply(BigDecimal.valueOf(applyDiscountCount));
        if (basalPricedRemainder > 0)
            discountedPrice = discountedPrice.add(BigDecimal.valueOf(basalPricedRemainder).multiply(basePricing.getPrice()));

        return totalPrice.subtract(discountedPrice);
    };

    static final Function<Object, BigDecimal> itemByWeightDiscount = item -> {
        var itemByWeight = (ItemByWeight) item;

        if (discountNotApplicable(itemByWeight)) return BigDecimal.ZERO;

        var basePricing = itemByWeight.getProduct().getPricingOffer().getBasePricing();
        var discountPricing = itemByWeight.getProduct().getPricingOffer().getDiscountPricing().orElseThrow();

        var totalPrice = itemByWeight.getWeightInKilos().multiply(basePricing.getPrice());
        var basalPricedRemainder = itemByWeight.getWeightInKilos().remainder(discountPricing.getUnitsInKilos());
        var applyDiscountCount = itemByWeight.getWeightInKilos().divideToIntegralValue(discountPricing.getUnitsInKilos());

        var discountedPrice = discountPricing.getPrice().multiply(applyDiscountCount);
        if (basalPricedRemainder.compareTo(BigDecimal.ZERO) > 0)
            discountedPrice = discountedPrice.add(basalPricedRemainder.multiply(basePricing.getPrice()));

        return totalPrice.subtract(discountedPrice);
    };

    private static boolean discountNotApplicable(ItemByUnit itemByUnit) {
        var discountPricing = itemByUnit.getProduct().getPricingOffer().getDiscountPricing();
        return discountPricing.isEmpty() || itemByUnit.getUnits() < discountPricing.get().getUnits();
    }

    private static boolean discountNotApplicable(ItemByWeight itemByWeight) {
        var discountPricing = itemByWeight.getProduct().getPricingOffer().getDiscountPricing();
        return discountPricing.isEmpty()
                || itemByWeight.getWeightInKilos().compareTo(discountPricing.get().getUnitsInKilos()) < 0;
    }
}
