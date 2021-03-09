package com.github.cc007.currying;

import com.github.cc007.currying.function.curried.CurriedBiFunction;
import com.github.cc007.currying.function.curried.CurriedFunction;
import com.github.cc007.currying.function.util.Apply;
import com.github.cc007.currying.function.util.Curry;
import lombok.val;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class App {

    public static void main(String[] args) {
        val map = new HashMap<String, Integer>();
        CurriedBiFunction<String, Integer, Integer> function = map::put;
        System.out.println(Apply.apply(function.curry("foo").curry(42)));
        System.out.println(Apply.apply(((CurriedBiFunction<String, Integer, Integer>) map::put).curry("foo").curry(69)));
        System.out.println(Apply.apply(Curry.get(map::put).curry("foo").curry(420)));
        System.out.println(Apply.apply(map::put, "bar", 42));

        val stringMap = new HashMap<String, String>();
        val mapFunc = Curry.get(stringMap::put);
        val curriedFunc = mapFunc.curry("key");
        val curriedSupplier = curriedFunc.curry("value");
        System.out.println(curriedSupplier.get());


        Map<String, String> stringMap2 = new HashMap<>();
        CurriedBiFunction<String, String, String> mapFunc2 = stringMap2::put;
        CurriedFunction<String, String> curriedFunc2 = mapFunc2.curry("key");
        Supplier<String> curriedSupplier2 = curriedFunc2.curry("value");
        System.out.println(curriedSupplier2.get());

        Apply.apply(map::put, "test", 42);
        Curry.curry(map::put, "test", 43).get();
    }
}
