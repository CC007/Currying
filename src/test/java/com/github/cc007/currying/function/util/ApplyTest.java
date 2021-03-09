package com.github.cc007.currying.function.util;

import com.github.cc007.currying.ExampleObject;
import com.github.cc007.currying.function.QuadFunction;
import com.github.cc007.currying.function.QuintFunction;
import com.github.cc007.currying.function.TriFunction;
import com.github.cc007.currying.function.curried.CurriedQuintFunction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

@ExtendWith(MockitoExtension.class)
class ApplyTest {

    @Mock
    private ExampleObject exampleObject;

    private CurriedQuintFunction<ExampleObject, ExampleObject, ExampleObject, ExampleObject, ExampleObject, ExampleObject> fiveParameterFunction;

    @BeforeEach
    void setup() {
        Mockito.when(exampleObject.fiveParameterFunction(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject)).thenReturn(exampleObject);
        fiveParameterFunction = exampleObject::fiveParameterFunction;
    }

    @Test
    void get() {
        //prepare
        Supplier<ExampleObject> method = fiveParameterFunction.curry(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);

        //execute
        Apply.get(method);

        //verify
        Mockito.verify(exampleObject).fiveParameterFunction(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);
    }

    @Test
    void applyWithoutParameters() {
        //prepare
        Supplier<ExampleObject> method = fiveParameterFunction.curry(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);

        //execute
        Apply.apply(method);

        //verify
        Mockito.verify(exampleObject).fiveParameterFunction(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);
    }

    @Test
    void applyWithOneParameter() {
        //prepare
        Function<ExampleObject, ExampleObject> method = fiveParameterFunction.curry(exampleObject, exampleObject, exampleObject, exampleObject);

        //execute
        Apply.apply(method, exampleObject);

        //verify
        Mockito.verify(exampleObject).fiveParameterFunction(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);
    }

    @Test
    void applyWithTwoParameters() {
        //prepare
        BiFunction<ExampleObject, ExampleObject, ExampleObject> method = fiveParameterFunction.curry(exampleObject, exampleObject, exampleObject);

        //execute
        Apply.apply(method, exampleObject, exampleObject);

        //verify
        Mockito.verify(exampleObject).fiveParameterFunction(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);
    }

    @Test
    void applyWithThreeParameters() {
        //prepare
        TriFunction<ExampleObject, ExampleObject, ExampleObject, ExampleObject> method = fiveParameterFunction.curry(exampleObject, exampleObject);

        //execute
        Apply.apply(method, exampleObject, exampleObject, exampleObject);

        //verify
        Mockito.verify(exampleObject).fiveParameterFunction(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);
    }

    @Test
    void applyWithFourParameters() {
        //prepare
        QuadFunction<ExampleObject, ExampleObject, ExampleObject, ExampleObject, ExampleObject> method = fiveParameterFunction.curry(exampleObject);

        //execute
        Apply.apply(method, exampleObject, exampleObject, exampleObject, exampleObject);

        //verify
        Mockito.verify(exampleObject).fiveParameterFunction(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);
    }

    @Test
    void applyWithFiveParameters() {
        //prepare
        QuintFunction<ExampleObject, ExampleObject, ExampleObject, ExampleObject, ExampleObject, ExampleObject> method = fiveParameterFunction;

        //execute
        Apply.apply(method, exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);

        //verify
        Mockito.verify(exampleObject).fiveParameterFunction(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);
    }
}