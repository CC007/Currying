package com.github.cc007.currying.function.curried;

import java.util.function.Consumer;

@FunctionalInterface
public interface CurriedConsumer<T> extends Consumer<T> {
    default Runnable curry(T t) {
        return () -> this.accept(t);
    }
}
