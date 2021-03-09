package com.github.cc007.currying.function.curried;

import com.github.cc007.currying.ExampleObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CurriedTriConsumerTest {

    @Mock
    private ExampleObject exampleObject1;

    @Mock
    private ExampleObject exampleObject2;

    @Mock
    private ExampleObject exampleObject3;

    private CurriedTriConsumer<ExampleObject, ExampleObject, ExampleObject> triConsumer;

    @BeforeEach
    void setup() {
        Mockito.doNothing().when(exampleObject1).foo();
        Mockito.doNothing().when(exampleObject2).foo();
        Mockito.doNothing().when(exampleObject3).foo();
        triConsumer = (ExampleObject obj1, ExampleObject obj2, ExampleObject obj3) -> {
            obj1.foo();
            obj2.foo();
            obj3.foo();
        };
    }

    @Test
    void curryWithOneParameter() {
        //prepare

        //execute
        CurriedBiConsumer<ExampleObject, ExampleObject> biConsumer = triConsumer.curry(exampleObject1);

        //verify
        Mockito.verify(exampleObject1, Mockito.times(0)).foo();
        biConsumer.accept(exampleObject2, exampleObject3);
        Mockito.verify(exampleObject1).foo();
        Mockito.verify(exampleObject2).foo();
        Mockito.verify(exampleObject3).foo();
    }

    @Test
    void curryWithTwoParameters() {
        //prepare

        //execute
        CurriedConsumer<ExampleObject> consumer = triConsumer.curry(exampleObject1, exampleObject2);

        //verify
        Mockito.verify(exampleObject1, Mockito.times(0)).foo();
        Mockito.verify(exampleObject2, Mockito.times(0)).foo();
        consumer.accept(exampleObject3);
        Mockito.verify(exampleObject1).foo();
        Mockito.verify(exampleObject2).foo();
        Mockito.verify(exampleObject3).foo();
    }

    @Test
    void curryWithThreeParameters() {
        //prepare

        //execute
        Runnable runnable = triConsumer.curry(exampleObject1, exampleObject2, exampleObject3);

        //verify
        Mockito.verify(exampleObject1, Mockito.times(0)).foo();
        Mockito.verify(exampleObject2, Mockito.times(0)).foo();
        Mockito.verify(exampleObject3, Mockito.times(0)).foo();
        runnable.run();
        Mockito.verify(exampleObject1).foo();
        Mockito.verify(exampleObject2).foo();
        Mockito.verify(exampleObject3).foo();
    }

}