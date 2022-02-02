package kata.supermarket.discount;

import kata.supermarket.ItemByUnit;
import kata.supermarket.ItemByWeight;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Function;

import static kata.supermarket.discount.Discounts.itemByUnitDiscount;
import static kata.supermarket.discount.Discounts.itemByWeightDiscount;

public class DiscountVisitorImpl {

    private static final Map<Class<?>, Function<Object, BigDecimal>> registry = Map.of(
            ItemByUnit.class, itemByUnitDiscount,
            ItemByWeight.class, itemByWeightDiscount
    );

    public static DiscountVisitor<BigDecimal> get = o -> registry.get(o.getClass()).apply(o);

}
