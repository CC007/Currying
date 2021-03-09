package com.github.cc007.currying.function.curried;

import com.github.cc007.currying.function.Blank;
import com.github.cc007.currying.function.QuadConsumer;

@FunctionalInterface
public interface CurriedQuadConsumer<T, U, V, W> extends QuadConsumer<T, U, V, W> {

    default CurriedTriConsumer<U, V, W> curry(T t) {
        return (U u, V v, W w) -> this.accept(t, u, v, w);
    }
    default CurriedTriConsumer<T, V, W> curry(Blank b, U u) {
        return (T t, V v, W w) -> this.accept(t, u, v, w);
    }
    default CurriedTriConsumer<T, U, W> curry(Blank b1, Blank b2, V v) {
        return (T t, U u, W w) -> this.accept(t, u, v, w);
    }
    default CurriedTriConsumer<T, U, V> curry(Blank b1, Blank b2, Blank b3, W w) {
        return (T t, U u, V v) -> this.accept(t, u, v, w);
    }

    default CurriedBiConsumer<V, W> curry(T t, U u) {
        return (V v, W w) -> this.accept(t, u, v, w);
    }
    default CurriedBiConsumer<T, W> curry(Blank b, U u, V v) {
        return (T t, W w) -> this.accept(t, u, v, w);
    }
    default CurriedBiConsumer<T, U> curry(Blank b1, Blank b2, V v, W w) {
        return (T t, U u) -> this.accept(t, u, v, w);
    }
    default CurriedBiConsumer<U, W> curry(T t, Blank b, V v) {
        return (U u, W w) -> this.accept(t, u, v, w);
    }
    default CurriedBiConsumer<T, V> curry(Blank b1, U u, Blank b2, W w) {
        return (T t, V v) -> this.accept(t, u, v, w);
    }
    default CurriedBiConsumer<U, V> curry(T t, Blank b1, Blank b2, W w) {
        return (U u, V v) -> this.accept(t, u, v, w);
    }

    default CurriedConsumer<W> curry(T t, U u, V v) {
        return (W w) -> this.accept(t, u, v, w);
    }
    default CurriedConsumer<V> curry(T t, U u, Blank b, W w) {
        return (V v) -> this.accept(t, u, v, w);
    }
    default CurriedConsumer<U> curry(T t, Blank b, V v, W w) {
        return (U u) -> this.accept(t, u, v, w);
    }
    default CurriedConsumer<T> curry(Blank b, U u, V v, W w) {
        return (T t) -> this.accept(t, u, v, w);
    }

    default Runnable curry(T t, U u, V v, W w) {
        return () -> this.accept(t, u, v, w);
    }
}
