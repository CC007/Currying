package com.github.cc007.currying.function.curried;

import com.github.cc007.currying.function.QuintFunction;

import java.util.function.Supplier;

@FunctionalInterface
public interface CurriedQuintFunction<T, U, V, W, X, R> extends QuintFunction<T, U, V, W, X, R> {

    default CurriedQuadFunction<U, V, W, X, R> curry(T t) {
        return (U u, V v, W w, X x) -> this.apply(t, u, v, w, x);
    }

    default CurriedTriFunction<V, W, X, R> curry(T t, U u) {
        return (V v, W w, X x) -> this.apply(t, u, v, w, x);
    }

    default CurriedBiFunction<W, X, R> curry(T t, U u, V v) {
        return (W w, X x) -> this.apply(t, u, v, w, x);
    }

    default CurriedFunction<X, R> curry(T t, U u, V v, W w) {
        return (X x) -> this.apply(t, u, v, w, x);
    }

    default Supplier<R> curry(T t, U u, V v, W w, X x) {
        return () -> this.apply(t, u, v, w, x);
    }
}
