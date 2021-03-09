package com.github.cc007.currying.function.util;

import com.github.cc007.currying.function.curried.*;
import lombok.experimental.UtilityClass;

import java.util.function.Supplier;

@UtilityClass
public class Curry {

    public <T, U, V, W, X, R> CurriedQuintFunction<T, U, V, W, X, R> get(CurriedQuintFunction<T, U, V, W, X, R> curriedQuintFunction) {
        return curriedQuintFunction;
    }

    public <T, U, V, W, R> CurriedQuadFunction<T, U, V, W, R> get(CurriedQuadFunction<T, U, V, W, R> curriedQuadFunction) {
        return curriedQuadFunction;
    }

    public <T, U, V, R> CurriedTriFunction<T, U, V, R> get(CurriedTriFunction<T, U, V, R> curriedTriFunction) {
        return curriedTriFunction;
    }

    public <T, U, R> CurriedBiFunction<T, U, R> get(CurriedBiFunction<T, U, R> curriedBiFunction) {
        return curriedBiFunction;
    }

    public <T, R> CurriedFunction<T, R> get(CurriedFunction<T, R> curriedFunction) {
        return curriedFunction;
    }

    public <T, U, V, W, X, R> Supplier<R> curry(CurriedQuintFunction<T, U, V, W, X, R> quintFunction, T t, U u, V v, W w, X x) {
        return quintFunction.curry(t, u, v, w, x);
    }

    public <T, U, V, W, X, R> CurriedFunction<X, R> curry(CurriedQuintFunction<T, U, V, W, X, R> quintFunction, T t, U u, V v, W w) {
        return quintFunction.curry(t, u, v, w);
    }

    public <T, U, V, W, X, R> CurriedBiFunction<W, X, R> curry(CurriedQuintFunction<T, U, V, W, X, R> quintFunction, T t, U u, V v) {
        return quintFunction.curry(t, u, v);
    }

    public <T, U, V, W, X, R> CurriedTriFunction<V, W, X, R> curry(CurriedQuintFunction<T, U, V, W, X, R> quintFunction, T t, U u) {
        return quintFunction.curry(t, u);
    }

    public <T, U, V, W, X, R> CurriedQuadFunction<U, V, W, X, R> curry(CurriedQuintFunction<T, U, V, W, X, R> quintFunction, T t) {
        return quintFunction.curry(t);
    }

    public <T, U, V, W, R> Supplier<R> curry(CurriedQuadFunction<T, U, V, W, R> quadFunction, T t, U u, V v, W w) {
        return quadFunction.curry(t, u, v, w);
    }

    public <T, U, V, W, R> CurriedFunction<W, R> curry(CurriedQuadFunction<T, U, V, W, R> quadFunction, T t, U u, V v) {
        return quadFunction.curry(t, u, v);
    }

    public <T, U, V, W, R> CurriedBiFunction<V, W, R> curry(CurriedQuadFunction<T, U, V, W, R> quadFunction, T t, U u) {
        return quadFunction.curry(t, u);
    }

    public <T, U, V, W, R> CurriedTriFunction<U, V, W, R> curry(CurriedQuadFunction<T, U, V, W, R> quadFunction, T t) {
        return quadFunction.curry(t);
    }

    public <T, U, V, R> Supplier<R> curry(CurriedTriFunction<T, U, V, R> triFunction, T t, U u, V v) {
        return triFunction.curry(t, u, v);
    }

    public <T, U, V, R> CurriedFunction<V, R> curry(CurriedTriFunction<T, U, V, R> triFunction, T t, U u) {
        return triFunction.curry(t, u);
    }

    public <T, U, V, R> CurriedBiFunction<U, V, R> curry(CurriedTriFunction<T, U, V, R> triFunction, T t) {
        return triFunction.curry(t);
    }

    public <T, U, R> Supplier<R> curry(CurriedBiFunction<T, U, R> biFunction, T t, U u) {
        return biFunction.curry(t, u);
    }

    public <T, U, R> CurriedFunction<U, R> curry(CurriedBiFunction<T, U, R> biFunction, T t) {
        return biFunction.curry(t);
    }

    public <T, R> Supplier<R> curry(CurriedFunction<T, R> function, T t) {
        return function.curry(t);
    }
}
