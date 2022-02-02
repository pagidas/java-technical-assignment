package kata.supermarket.discount;

public interface Discountable<MONETARY_VALUE> {
    MONETARY_VALUE discount(DiscountVisitor<MONETARY_VALUE> visitor);
}