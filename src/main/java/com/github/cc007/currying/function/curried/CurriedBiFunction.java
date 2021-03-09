package com.github.cc007.currying.function.curried;

import java.util.function.BiFunction;
import java.util.function.Supplier;

@FunctionalInterface
public interface CurriedBiFunction<T, U, R> extends BiFunction<T, U, R> {

    default CurriedFunction<U, R> curry(T t) {
        return (U u) -> this.apply(t, u);
    }

    default Supplier<R> curry(T t, U u) {
        return () -> this.apply(t, u);
    }
}
