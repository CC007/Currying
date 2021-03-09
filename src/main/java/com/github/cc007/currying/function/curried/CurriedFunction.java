package com.github.cc007.currying.function.curried;

import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
public interface CurriedFunction<T, R> extends Function<T, R> {
    default Supplier<R> curry(T t) {
        return () -> this.apply(t);
    }
}
