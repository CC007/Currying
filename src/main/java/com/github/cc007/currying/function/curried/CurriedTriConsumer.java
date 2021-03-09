package com.github.cc007.currying.function.curried;

import com.github.cc007.currying.function.Blank;
import com.github.cc007.currying.function.TriConsumer;

@FunctionalInterface
public interface CurriedTriConsumer<T, U, V> extends TriConsumer<T, U, V> {

    default CurriedBiConsumer<U, V> curry(T t) {
        return (U u, V v) -> this.accept(t, u, v);
    }

    default CurriedBiConsumer<T, V> curry(Blank b, U u) {
        return (T t, V v) -> this.accept(t, u, v);
    }

    default CurriedBiConsumer<T, U> curry(Blank b1, Blank b2, V v) {
        return (T t, U u) -> this.accept(t, u, v);
    }

    default CurriedConsumer<V> curry(T t, U u) {
        return (V v) -> this.accept(t, u, v);
    }

    default CurriedConsumer<U> curry(T t, Blank b, V v) {
        return (U u) -> this.accept(t, u, v);
    }

    default CurriedConsumer<T> curry(Blank b, U u, V v) {
        return (T t) -> this.accept(t, u, v);
    }

    default Runnable curry(T t, U u, V v) {
        return () -> this.accept(t, u, v);
    }
}
