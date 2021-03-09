package com.github.cc007.currying.function.util;

import com.github.cc007.currying.ExampleObject;
import com.github.cc007.currying.function.QuadConsumer;
import com.github.cc007.currying.function.QuintConsumer;
import com.github.cc007.currying.function.TriConsumer;
import com.github.cc007.currying.function.curried.CurriedQuintConsumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@ExtendWith(MockitoExtension.class)
class AcceptTest {

    @Mock
    private ExampleObject exampleObject;

    private CurriedQuintConsumer<ExampleObject, ExampleObject, ExampleObject, ExampleObject, ExampleObject> fiveParameterConsumer;

    @BeforeEach
    void setup() {
        Mockito.doNothing().when(exampleObject).fiveParameterConsumer(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);
        fiveParameterConsumer = exampleObject::fiveParameterConsumer;
    }

    @Test
    void run() {
        //prepare
        Runnable method = fiveParameterConsumer.curry(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);

        //execute
        Accept.run(method);

        //verify
        Mockito.verify(exampleObject).fiveParameterConsumer(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);
    }

    @Test
    void acceptWithoutParameters() {
        //prepare
        Runnable method = fiveParameterConsumer.curry(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);

        //execute
        Accept.accept(method);

        //verify
        Mockito.verify(exampleObject).fiveParameterConsumer(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);
    }

    @Test
    void acceptWithOneParameter() {
        //prepare
        Consumer<ExampleObject> method = fiveParameterConsumer.curry(exampleObject, exampleObject, exampleObject, exampleObject);

        //execute
        Accept.accept(method, exampleObject);

        //verify
        Mockito.verify(exampleObject).fiveParameterConsumer(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);
    }

    @Test
    void acceptWithTwoParameters() {
        //prepare
        BiConsumer<ExampleObject, ExampleObject> method = fiveParameterConsumer.curry(exampleObject, exampleObject, exampleObject);

        //execute
        Accept.accept(method, exampleObject, exampleObject);

        //verify
        Mockito.verify(exampleObject).fiveParameterConsumer(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);
    }

    @Test
    void acceptWithThreeParameters() {
        //prepare
        TriConsumer<ExampleObject, ExampleObject, ExampleObject> method = fiveParameterConsumer.curry(exampleObject, exampleObject);

        //execute
        Accept.accept(method, exampleObject, exampleObject, exampleObject);

        //verify
        Mockito.verify(exampleObject).fiveParameterConsumer(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);
    }

    @Test
    void acceptWithFourParameters() {
        //prepare
        QuadConsumer<ExampleObject, ExampleObject, ExampleObject, ExampleObject> method = fiveParameterConsumer.curry(exampleObject);

        //execute
        Accept.accept(method, exampleObject, exampleObject, exampleObject, exampleObject);

        //verify
        Mockito.verify(exampleObject).fiveParameterConsumer(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);
    }

    @Test
    void acceptWithFiveParameters() {
        //prepare
        QuintConsumer<ExampleObject, ExampleObject, ExampleObject, ExampleObject, ExampleObject> method = fiveParameterConsumer;

        //execute
        Accept.accept(method, exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);

        //verify
        Mockito.verify(exampleObject).fiveParameterConsumer(exampleObject, exampleObject, exampleObject, exampleObject, exampleObject);
    }

}