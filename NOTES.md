# Notes

Please add here any notes, assumptions and design decisions that might help up understand your though process.

### Future improvements

With the way the code is designed, `Basket` is sort of an api; it's the main entry point
of a group of capabilities that a client can:
- add items (by weight or unit).
- get the total price adjusting discount accordingly.

Given my above understanding, the only test that is valid to keep this api rigid is the `BasketTest`.
And in there we should aim towards testing only its behaviour, and not implementation details. From
that entry point (`Basket` api) everything that follows after are implementation details. So however
the code is structured and modeled, the behaviour of the api expressed in `BasketTest` should remain
the same. It is only modified when we stopped supporting a particular use case.

We would be better off removing tests like: `ProductTest` and `WeightedProductTest`, as they increase
the time we have to go back and adjust all the tests that are now out of date because of a refactoring.

