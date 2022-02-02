package kata.supermarket;

import java.math.BigDecimal;

public class Products {

    private Products() { }

    public static ProductBuilder buildByUnit() {
        return new ProductBuilder();
    }

    public static WeightedProductBuilder buildByWeight() {
        return new WeightedProductBuilder();
    }

    public static class ProductBuilder {

        private Pricing basePricing;
        private Pricing discountPricing;

        private ProductBuilder() { }

        public ProductBuilder withBasePricing(Pricing basePricing) {
            this.basePricing = basePricing;
            return this;
        }

        public ProductBuilder withBasePricing(int units, String price) {
            this.basePricing = new Pricing(units, new BigDecimal(price));
            return this;
        }

        public ProductBuilder withDiscountPricing(Pricing discountPricing) {
            this.discountPricing = discountPricing;
            return this;
        }

        public ProductBuilder withDiscountPricing(int units, String price) {
            this.discountPricing = new Pricing(units, new BigDecimal(price));
            return this;
        }

        public Product get() {
            return new Product(new PricingOffer(basePricing, discountPricing));
        }

    }

    public static class WeightedProductBuilder {

        private WeightedPricing basePricing;
        private WeightedPricing discountPricing;

        private WeightedProductBuilder() { }

        public WeightedProductBuilder withBasePricing(WeightedPricing basePricing) {
            this.basePricing = basePricing;
            return this;
        }

        public WeightedProductBuilder withBasePricing(String unitsInKilos, String price) {
            this.basePricing = new WeightedPricing(new BigDecimal(unitsInKilos), new BigDecimal(price));
            return this;
        }

        public WeightedProductBuilder withDiscountPricing(WeightedPricing discountPricing) {
            this.discountPricing = discountPricing;
            return this;
        }

        public WeightedProductBuilder withDiscountPricing(String unitsInKilos, String price) {
            this.discountPricing = new WeightedPricing(new BigDecimal(unitsInKilos), new BigDecimal(price));
            return this;
        }

        public WeightedProduct get() {
            return new WeightedProduct(new WeightedPricingOffer(basePricing, discountPricing));
        }

    }

}
