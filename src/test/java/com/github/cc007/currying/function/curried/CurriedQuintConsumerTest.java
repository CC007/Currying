package com.github.cc007.currying.function.curried;

import com.github.cc007.currying.ExampleObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CurriedQuintConsumerTest {

    @Mock
    private ExampleObject exampleObject1;

    @Mock
    private ExampleObject exampleObject2;

    @Mock
    private ExampleObject exampleObject3;

    @Mock
    private ExampleObject exampleObject4;

    @Mock
    private ExampleObject exampleObject5;

    private CurriedQuintConsumer<ExampleObject, ExampleObject, ExampleObject, ExampleObject, ExampleObject> triConsumer;

    @BeforeEach
    void setup() {
        Mockito.doNothing().when(exampleObject1).foo();
        Mockito.doNothing().when(exampleObject2).foo();
        Mockito.doNothing().when(exampleObject3).foo();
        Mockito.doNothing().when(exampleObject4).foo();
        Mockito.doNothing().when(exampleObject5).foo();
        triConsumer = (ExampleObject obj1, ExampleObject obj2, ExampleObject obj3, ExampleObject obj4, ExampleObject obj5) -> {
            obj1.foo();
            obj2.foo();
            obj3.foo();
            obj4.foo();
            obj5.foo();
        };
    }

    @Test
    void curryWithOneParameter() {
        //prepare

        //execute
        CurriedQuadConsumer<ExampleObject, ExampleObject, ExampleObject, ExampleObject> biConsumer = triConsumer.curry(exampleObject1);

        //verify
        Mockito.verify(exampleObject1, Mockito.times(0)).foo();
        biConsumer.accept(exampleObject2, exampleObject3, exampleObject4, exampleObject5);
        Mockito.verify(exampleObject1).foo();
        Mockito.verify(exampleObject2).foo();
        Mockito.verify(exampleObject3).foo();
        Mockito.verify(exampleObject4).foo();
        Mockito.verify(exampleObject5).foo();
    }

    @Test
    void curryWithTwoParameter() {
        //prepare

        //execute
        CurriedTriConsumer<ExampleObject, ExampleObject, ExampleObject> biConsumer = triConsumer.curry(exampleObject1, exampleObject2);

        //verify
        Mockito.verify(exampleObject1, Mockito.times(0)).foo();
        Mockito.verify(exampleObject2, Mockito.times(0)).foo();
        biConsumer.accept(exampleObject3, exampleObject4, exampleObject5);
        Mockito.verify(exampleObject1).foo();
        Mockito.verify(exampleObject2).foo();
        Mockito.verify(exampleObject3).foo();
        Mockito.verify(exampleObject4).foo();
        Mockito.verify(exampleObject5).foo();
    }

    @Test
    void curryWithThreeParameters() {
        //prepare

        //execute
        CurriedBiConsumer<ExampleObject, ExampleObject> biConsumer = triConsumer.curry(exampleObject1, exampleObject2, exampleObject3);

        //verify
        Mockito.verify(exampleObject1, Mockito.times(0)).foo();
        Mockito.verify(exampleObject2, Mockito.times(0)).foo();
        Mockito.verify(exampleObject3, Mockito.times(0)).foo();
        biConsumer.accept(exampleObject4, exampleObject5);
        Mockito.verify(exampleObject1).foo();
        Mockito.verify(exampleObject2).foo();
        Mockito.verify(exampleObject3).foo();
        Mockito.verify(exampleObject4).foo();
        Mockito.verify(exampleObject5).foo();
    }

    @Test
    void curryWithFourParameters() {
        //prepare

        //execute
        CurriedConsumer<ExampleObject> consumer = triConsumer.curry(exampleObject1, exampleObject2, exampleObject3, exampleObject4);

        //verify
        Mockito.verify(exampleObject1, Mockito.times(0)).foo();
        Mockito.verify(exampleObject2, Mockito.times(0)).foo();
        Mockito.verify(exampleObject3, Mockito.times(0)).foo();
        Mockito.verify(exampleObject4, Mockito.times(0)).foo();
        consumer.accept(exampleObject5);
        Mockito.verify(exampleObject1).foo();
        Mockito.verify(exampleObject2).foo();
        Mockito.verify(exampleObject3).foo();
        Mockito.verify(exampleObject4).foo();
        Mockito.verify(exampleObject5).foo();
    }

    @Test
    void curryWithFiveParameters() {
        //prepare

        //execute
        Runnable runnable = triConsumer.curry(exampleObject1, exampleObject2, exampleObject3, exampleObject4, exampleObject5);

        //verify
        Mockito.verify(exampleObject1, Mockito.times(0)).foo();
        Mockito.verify(exampleObject2, Mockito.times(0)).foo();
        Mockito.verify(exampleObject3, Mockito.times(0)).foo();
        Mockito.verify(exampleObject4, Mockito.times(0)).foo();
        Mockito.verify(exampleObject5, Mockito.times(0)).foo();
        runnable.run();
        Mockito.verify(exampleObject1).foo();
        Mockito.verify(exampleObject2).foo();
        Mockito.verify(exampleObject3).foo();
        Mockito.verify(exampleObject4).foo();
        Mockito.verify(exampleObject5).foo();
    }

}