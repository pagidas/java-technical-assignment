package kata.supermarket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {

    @DisplayName("basket provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, String expectedTotal, Iterable<Item> items) {
        final Basket basket = new Basket();
        items.forEach(basket::add);
        assertEquals(new BigDecimal(expectedTotal), basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
                noItems(),
                aSingleItemPricedPerUnit(),
                multipleItemsPricedPerUnit(),
                aSingleItemPricedByWeight(),
                multipleItemsPricedByWeight()
        );
    }

    private static Arguments aSingleItemPricedByWeight() {
        return Arguments.of("a single weighed item", "1.25", Collections.singleton(twoFiftyGramsOfAmericanSweets()));
    }

    private static Arguments multipleItemsPricedByWeight() {
        return Arguments.of("multiple weighed items", "1.85",
                Arrays.asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix())
        );
    }

    private static Arguments multipleItemsPricedPerUnit() {
        return Arguments.of("multiple items priced per unit", "2.04",
                Arrays.asList(onePackOfDigestives(), onePintOfMilk()));
    }

    private static Arguments aSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(onePintOfMilk()));
    }

    private static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

    private static Item onePackOfDigestives() {
        return Items.buildByUnit()
                .withProduct(aPackOfDigestives().get())
                .get();
    }

    private static Item onePintOfMilk() {
        return Items.buildByUnit()
                .withProduct(aPintOfMilk().get())
                .get();
    }

    private static Products.ProductBuilder aPintOfMilk() {
        return Products.buildByUnit()
                .withBasePricing(1, "0.49");
    }

    private static Products.ProductBuilder aPackOfDigestives() {
        return Products.buildByUnit()
                .withBasePricing(1, "1.55");
    }

    private static Products.WeightedProductBuilder looseAmericanSweet() {
        return Products.buildByWeight()
                .withBasePricing("1.00", "4.99");
    }

    private static Item twoFiftyGramsOfAmericanSweets() {
        return Items.buildByWeight()
                .withProduct(looseAmericanSweet().get())
                .withWeight(".25")
                .get();
    }

    private static Products.WeightedProductBuilder loosePickAndMix() {
        return Products.buildByWeight()
                .withBasePricing("1.00", "2.99");
    }

    private static Item twoHundredGramsOfPickAndMix() {
        return Items.buildByWeight()
                .withProduct(loosePickAndMix().get())
                .withWeight(".2")
                .get();
    }
}