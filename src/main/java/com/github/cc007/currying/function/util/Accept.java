package com.github.cc007.currying.function.util;

import com.github.cc007.currying.function.QuadConsumer;
import com.github.cc007.currying.function.QuintConsumer;
import com.github.cc007.currying.function.TriConsumer;
import lombok.experimental.UtilityClass;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@UtilityClass
public class Accept {

    public <T, U, V, W, X> void accept(QuintConsumer<T, U, V, W, X> quintConsumer, T t, U u, V v, W w, X x) {
        quintConsumer.accept(t, u, v, w, x);
    }

    public <T, U, V, W> void accept(QuadConsumer<T, U, V, W> quadConsumer, T t, U u, V v, W w) {
        quadConsumer.accept(t, u, v, w);
    }

    public <T, U, V> void accept(TriConsumer<T, U, V> triConsumer, T t, U u, V v) {
        triConsumer.accept(t, u, v);
    }

    public <T, U> void accept(BiConsumer<T, U> biConsumer, T t, U u) {
        biConsumer.accept(t, u);
    }

    public <T> void accept(Consumer<T> consumer, T t) {
        consumer.accept(t);
    }

    public <R> void accept(Runnable runnable) {
        runnable.run();
    }

    public <R> void run(Runnable runnable) {
        runnable.run();
    }
}
