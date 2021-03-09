package com.github.cc007.currying.function.curried;

import com.github.cc007.currying.function.TriFunction;

import java.util.function.Supplier;

@FunctionalInterface
public interface CurriedTriFunction<T, U, V, R> extends TriFunction<T, U, V, R> {

    default CurriedBiFunction<U, V, R> curry(T t) {
        return (U u, V v) -> this.apply(t, u, v);
    }

    default CurriedFunction<V, R> curry(T t, U u) {
        return (V v) -> this.apply(t, u, v);
    }

    default Supplier<R> curry(T t, U u, V v) {
        return () -> this.apply(t, u, v);
    }
}
