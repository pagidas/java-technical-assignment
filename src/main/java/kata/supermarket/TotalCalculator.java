package kata.supermarket;

import kata.supermarket.discount.DiscountVisitorImpl;
import kata.supermarket.discount.Discountable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class TotalCalculator {

    public static BigDecimal calculate(List<Item> items) {
        return subtotal(items).subtract(discounts(items));
    }

    private static BigDecimal subtotal(List<Item> items) {
        return items.stream().map(Item::price)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * TODO: This could be a good place to apply the results of
     *  the discount calculations.
     *  It is not likely to be the best place to do those calculations.
     *  Think about how Basket could interact with something
     *  which provides that functionality.
     */
    private static BigDecimal discounts(List<Item> items) {
        return items.stream()
                .map(item -> ((Discountable<BigDecimal>) item).discount(DiscountVisitorImpl.get))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

}