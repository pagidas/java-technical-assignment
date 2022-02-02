package kata.supermarket;

import java.math.BigDecimal;

public class Items {

    private Items() { }

    public static ItemByUnitBuilder buildByUnit() {
        return new ItemByUnitBuilder();
    }

    public static ItemByWeightBuilder buildByWeight() {
        return new ItemByWeightBuilder();
    }

    public static class ItemByUnitBuilder {

        private int itemUnits;
        private Product product;

        private ItemByUnitBuilder() { }

        public ItemByUnitBuilder withProduct(Product product) {
            this.product = product;
            return this;
        }

        public Item get() {
            this.itemUnits = 1;
            return new ItemByUnit(product, itemUnits);
        }

        public Item get(int units) {
            this.itemUnits = units;
            return new ItemByUnit(product, itemUnits);
        }

    }

    public static class ItemByWeightBuilder {

        private BigDecimal weightInKilos;
        private WeightedProduct product;

        private ItemByWeightBuilder() { }

        public ItemByWeightBuilder withWeight(String weightInKilos) {
            this.weightInKilos = new BigDecimal(weightInKilos);
            return this;
        }

        public ItemByWeightBuilder withProduct(WeightedProduct product) {
            this.product = product;
            return this;
        }

        public Item get() {
            return new ItemByWeight(product, weightInKilos);
        }

    }
}
