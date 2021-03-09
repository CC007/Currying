package com.github.cc007.currying.function.curried;

import com.github.cc007.currying.function.QuadFunction;

import java.util.function.Supplier;

@FunctionalInterface
public interface CurriedQuadFunction<T, U, V, W, R> extends QuadFunction<T, U, V, W, R> {

    default CurriedTriFunction<U, V, W, R> curry(T t) {
        return (U u, V v, W w) -> this.apply(t, u, v, w);
    }

    default CurriedBiFunction<V, W, R> curry(T t, U u) {
        return (V v, W w) -> this.apply(t, u, v, w);
    }

    default CurriedFunction<W, R> curry(T t, U u, V v) {
        return (W w) -> this.apply(t, u, v, w);
    }

    default Supplier<R> curry(T t, U u, V v, W w) {
        return () -> this.apply(t, u, v, w);
    }
}
