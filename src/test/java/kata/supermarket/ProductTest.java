package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void singleItemHasExpectedUnitPriceFromProduct() {
        final BigDecimal price = new BigDecimal("2.49");
        final PricingOffer pricingOffer = new PricingOffer(new Pricing(1, new BigDecimal("2.49")));
        assertEquals(price, new Product(pricingOffer).oneOf().price());
    }
}