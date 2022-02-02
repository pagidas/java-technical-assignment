package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void singleItemHasExpectedUnitPriceFromProduct() {
        final BigDecimal expectedPrice = new BigDecimal("2.49");
        final Item givenItem = Items.buildByUnit()
                .withProduct(Products.buildByUnit()
                        .withBasePricing(1, "2.49")
                        .get())
                .get();
        assertEquals(expectedPrice, givenItem.price());
    }
}