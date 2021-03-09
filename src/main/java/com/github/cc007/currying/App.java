package com.github.cc007.currying;

import com.github.cc007.currying.function.Blank;
import com.github.cc007.currying.function.curried.CurriedBiConsumer;
import com.github.cc007.currying.function.curried.CurriedBiFunction;
import com.github.cc007.currying.function.util.Accept;
import com.github.cc007.currying.function.util.Apply;
import com.github.cc007.currying.function.util.Curry;

import lombok.val;

import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        // how to get the curried function with a method reference
        CurriedBiFunction<Integer, Integer, Integer> function = Integer::max;
        // how to get the curried consumer with a lambda
        CurriedBiConsumer<Integer, Integer> consumer = (a, b) -> System.out.println(Integer.max(a, b));

        // basic use of the curried bifunction
        val result1 = function.curry(1).curry(2).get();
        // instead of using get(), you can also use Apply.get()
        val result2 = Apply.get(function.curry(7).curry(11));
        // instead of using get(), you can also use Apply.apply(...)
        val result3 = Apply.apply(function.curry(7), 11);
        // or apply all parameters
        val result4 = Apply.apply(function, 7, 11);
        // or curry all parameters (this is basically an alias for Apply.get()
        val result5 = Apply.apply(function.curry(7).curry(11));


        // You don't have to define the function beforehand. You do still need to specify the type this way though
        val result6 = Apply.apply(((CurriedBiFunction<Integer, Integer, Integer>) Integer::max).curry(42).curry(69));
        // A way to work around this is to use Curry.get(...)
        val result7 = Apply.apply(Curry.get(Integer::max).curry(42).curry(69));
        // or when not currying at all, the method signature of Apply.apply(...) is enough.
        val result8 = Apply.apply(Integer::max, 42, 69);

        // whether or not you can use lombok val also follows this rule
        CurriedBiFunction<Integer, Integer, Integer> function1 = Integer::max;
        val function2 = Curry.get(Integer::max);

        // of course you can also store the curried function into a variable
        val curriedFunc = function.curry(420);
        val result9 = curriedFunc.apply(1337);
        // and you can curry multiple parameters at the same time as well
        val curriedSupplier = function.curry(420, 1337);
        val result10 = curriedSupplier.get();
        // and you can also just curry the second parameter using Blank._ (TODO not implemented yet for functions)
        val anotherCurriedFunc = consumer.curry(Blank._, 1337);
        anotherCurriedFunc.accept(420);
        // or for Java 9+ Blank.BLANK
        val yetAnotherCurriedFunc = consumer.curry(Blank.BLANK, 1337);
        yetAnotherCurriedFunc.accept(420);

        // in the same way that you can specify multiple parameters in Apply.apply(...)
        val result11 = Apply.apply(function, 1, 2);
        // you can also specify multiple parameters in Accept.accept(...)
        Accept.accept(consumer, 1, 2);
        // or in Curry.curry(...)
        val result12 = Curry.curry(function, 1, 2).get();
        // TODO add Curry.curry(...) for consumers)
        //val result13 = Curry.curry(consumer, "test", 43).get();
    }
}
