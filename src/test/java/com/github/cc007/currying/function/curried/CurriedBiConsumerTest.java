package com.github.cc007.currying.function.curried;

import com.github.cc007.currying.ExampleObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.github.cc007.currying.function.Blank._;

@ExtendWith(MockitoExtension.class)
class CurriedBiConsumerTest {

    @Mock
    private ExampleObject exampleObject1;

    @Mock
    private ExampleObject exampleObject2;

    private CurriedBiConsumer<ExampleObject, ExampleObject> biConsumer;

    @BeforeEach
    void setup() {
        Mockito.doNothing().when(exampleObject1).foo();
        Mockito.doNothing().when(exampleObject2).foo();
        biConsumer = (ExampleObject obj1, ExampleObject obj2) -> {
            obj1.foo();
            obj2.foo();
        };
    }

    @Test
    void curryWithOneParameter() {
        //prepare

        //execute
        CurriedConsumer<ExampleObject> consumer = biConsumer.curry(exampleObject1);

        //verify
        Mockito.verify(exampleObject1, Mockito.times(0)).foo();
        consumer.accept(exampleObject2);
        Mockito.verify(exampleObject1).foo();
        Mockito.verify(exampleObject2).foo();
    }

    @Test
    void curryWithTwoParametersSecondBlank() {
        //prepare

        //execute
        CurriedConsumer<ExampleObject> consumer = biConsumer.curry(_, exampleObject2);

        //verify
        Mockito.verify(exampleObject2, Mockito.times(0)).foo();
        consumer.accept(exampleObject1);
        Mockito.verify(exampleObject1).foo();
        Mockito.verify(exampleObject2).foo();
    }

    @Test
    void curryWithTwoParameters() {
        //prepare

        //execute
        Runnable runnable = biConsumer.curry(exampleObject1, exampleObject2);

        //verify
        Mockito.verify(exampleObject1, Mockito.times(0)).foo();
        Mockito.verify(exampleObject2, Mockito.times(0)).foo();
        runnable.run();
        Mockito.verify(exampleObject1).foo();
        Mockito.verify(exampleObject2).foo();
    }
}