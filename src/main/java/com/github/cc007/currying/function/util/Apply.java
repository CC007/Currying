package com.github.cc007.currying.function.util;

import com.github.cc007.currying.function.QuadFunction;
import com.github.cc007.currying.function.QuintFunction;
import com.github.cc007.currying.function.TriFunction;
import lombok.experimental.UtilityClass;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

@UtilityClass
public class Apply {

    public <T, U, V, W, X, R> R apply(QuintFunction<T, U, V, W, X, R> quintFunction, T t, U u, V v, W w, X x) {
        return quintFunction.apply(t, u, v, w, x);
    }

    public <T, U, V, W, R> R apply(QuadFunction<T, U, V, W, R> quadFunction, T t, U u, V v, W w) {
        return quadFunction.apply(t, u, v, w);
    }

    public <T, U, V, R> R apply(TriFunction<T, U, V, R> triFunction, T t, U u, V v) {
        return triFunction.apply(t, u, v);
    }

    public <T, U, R> R apply(BiFunction<T, U, R> biFunction, T t, U u) {
        return biFunction.apply(t, u);
    }

    public <T, R> R apply(Function<T, R> function, T t) {
        return function.apply(t);
    }

    public <R> R apply(Supplier<R> supplier) {
        return supplier.get();
    }

    public <R> R get(Supplier<R> supplier) {
        return supplier.get();
    }
}
