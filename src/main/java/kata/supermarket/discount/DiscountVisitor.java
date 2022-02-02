package kata.supermarket.discount;

public interface DiscountVisitor<R> {
    R calculate(Object o);
}
