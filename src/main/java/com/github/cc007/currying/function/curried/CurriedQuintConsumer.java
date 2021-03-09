package com.github.cc007.currying.function.curried;

import com.github.cc007.currying.function.Blank;
import com.github.cc007.currying.function.QuintConsumer;

@FunctionalInterface
public interface CurriedQuintConsumer<T, U, V, W, X> extends QuintConsumer<T, U, V, W, X> {

    default CurriedQuadConsumer<U, V, W, X> curry(T t) {
        return (U u, V v, W w, X x) -> this.accept(t, u, v, w, x);
    }
    default CurriedQuadConsumer<T, V, W, X> curry(Blank b, U u) {
        return (T t, V v, W w, X x) -> this.accept(t, u, v, w, x);
    }
    default CurriedQuadConsumer<T, U, W, X> curry(Blank b1, Blank b2, V v) {
        return (T t, U u, W w, X x) -> this.accept(t, u, v, w, x);
    }
    default CurriedQuadConsumer<T, U, V, X> curry(Blank b1, Blank b2, Blank b3, W w) {
        return (T t, U u, V v, X x) -> this.accept(t, u, v, w, x);
    }
    default CurriedQuadConsumer<T, U, V, W> curry(Blank b1, Blank b2, Blank b3, Blank b4, X x) {
        return (T t, U u, V v, W w) -> this.accept(t, u, v, w, x);
    }

    default CurriedTriConsumer<V, W, X> curry(T t, U u) {
        return (V v, W w, X x) -> this.accept(t, u, v, w, x);
    }
    default CurriedTriConsumer<T, W, X> curry(Blank b, U u, V v) {
        return (T t, W w, X x) -> this.accept(t, u, v, w, x);
    }
    default CurriedTriConsumer<T, U, X> curry(Blank b1, Blank b2, V v, W w) {
        return (T t, U u, X x) -> this.accept(t, u, v, w, x);
    }
    default CurriedTriConsumer<T, U, V> curry(Blank b1, Blank b2, Blank b3, W w, X x) {
        return (T t, U u, V v) -> this.accept(t, u, v, w, x);
    }
    default CurriedTriConsumer<U, W, X> curry(T t, Blank b, V v) {
        return (U u, W w, X x) -> this.accept(t, u, v, w, x);
    }
    default CurriedTriConsumer<T, V, X> curry(Blank b1, U u, Blank b2, W w) {
        return (T t, V v, X x) -> this.accept(t, u, v, w, x);
    }
    default CurriedTriConsumer<T, U, W>curry(Blank b1, Blank b2, V v, Blank b3, X x) {
        return (T t, U u, W w) -> this.accept(t, u, v, w, x);
    }
    default CurriedTriConsumer<U, V, X> curry(T t, Blank b1, Blank b2, W w) {
        return (U u, V v, X x) -> this.accept(t, u, v, w, x);
    }
    default CurriedTriConsumer<T, V, W> curry(Blank b1, U u, Blank b2, Blank b3, X x) {
        return (T t, V v, W w) -> this.accept(t, u, v, w, x);
    }
    default CurriedTriConsumer<U, V, W> curry(T t, Blank b1, Blank b2, Blank b3, X x) {
        return (U u, V v, W w) -> this.accept(t, u, v, w, x);
    }

    default CurriedBiConsumer<W, X> curry(T t, U u, V v) {
        return (W w, X x) -> this.accept(t, u, v, w, x);
    }
    default CurriedBiConsumer<V, W> curry(T t, U u, Blank b1, Blank b2, X x) {
        return (V v, W w) -> this.accept(t, u, v, w, x);
    }
    default CurriedBiConsumer<U, V> curry(T t, Blank b1, Blank b2, W w, X x) {
        return (U u, V v) -> this.accept(t, u, v, w, x);
    }
    default CurriedBiConsumer<T, U> curry(Blank b1, Blank b2, V v, W w, X x) {
        return (T t, U u) -> this.accept(t, u, v, w, x);
    }
    default CurriedBiConsumer<V, X> curry(T t, U u, Blank b, W w) {
        return (V v, X x) -> this.accept(t, u, v, w, x);
    }
    default CurriedBiConsumer<U, W> curry(T t, Blank b1, V v, Blank b2, X x) {
        return (U u, W w) -> this.accept(t, u, v, w, x);
    }
    default CurriedBiConsumer<T, V> curry(Blank b1, U u, Blank b2, W w, X x) {
        return (T t, V v) -> this.accept(t, u, v, w, x);
    }
    default CurriedBiConsumer<U, X> curry(T t, Blank b, V v, W w) {
        return (U u, X x) -> this.accept(t, u, v, w, x);
    }
    default CurriedBiConsumer<T, W> curry(Blank b1, U u, V v, Blank b2, X x) {
        return (T t, W w) -> this.accept(t, u, v, w, x);
    }
    default CurriedBiConsumer<T, X> curry(Blank b, U u, V v, W w) {
        return (T t, X x) -> this.accept(t, u, v, w, x);
    }

    default CurriedConsumer<X> curry(T t, U u, V v, W w) {
        return (X x) -> this.accept(t, u, v, w, x);
    }
    default CurriedConsumer<W> curry(T t, U u, V v, Blank b, X x) {
        return (W w) -> this.accept(t, u, v, w, x);
    }
    default CurriedConsumer<V> curry(T t, U u, Blank b, W w, X x) {
        return (V v) -> this.accept(t, u, v, w, x);
    }
    default CurriedConsumer<U> curry(T t, Blank b, V v, W w, X x) {
        return (U u) -> this.accept(t, u, v, w, x);
    }
    default CurriedConsumer<T> curry(Blank b, U u, V v, W w, X x) {
        return (T t) -> this.accept(t, u, v, w, x);
    }

    default Runnable curry(T t, U u, V v, W w, X x) {
        return () -> this.accept(t, u, v, w, x);
    }
}























