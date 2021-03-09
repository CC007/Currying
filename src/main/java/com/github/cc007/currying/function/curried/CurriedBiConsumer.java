package com.github.cc007.currying.function.curried;

import com.github.cc007.currying.function.Blank;

import java.util.function.BiConsumer;

@FunctionalInterface
public interface CurriedBiConsumer<T, U> extends BiConsumer<T, U> {

    default CurriedConsumer<U> curry(T t) {
        return (U u) -> this.accept(t, u);
    }

    default CurriedConsumer<T> curry(Blank b, U u) {
        return (T t) -> this.accept(t, u);
    }

    default Runnable curry(T t, U u) {
        return () -> this.accept(t, u);
    }
}
