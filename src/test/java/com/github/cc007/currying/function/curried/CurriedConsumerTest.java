package com.github.cc007.currying.function.curried;

import com.github.cc007.currying.ExampleObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CurriedConsumerTest {

    @Mock
    private ExampleObject exampleObject;

    @Test
    void curry() {
        //prepare
        Mockito.doNothing().when(exampleObject).foo();
        CurriedConsumer<ExampleObject> consumer = ExampleObject::foo;

        //execute
        Runnable runnable = consumer.curry(exampleObject);

        //verify
        runnable.run();
        Mockito.verify(exampleObject).foo();
    }
}