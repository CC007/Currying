package com.github.cc007.currying.function.curried;

import com.github.cc007.currying.ExampleObject;
import org.hamcrest.collection.IsMapContaining;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Map;
import java.util.function.Supplier;

@ExtendWith(MockitoExtension.class)
class CurriedBiFunctionTest {

    @Mock
    private ExampleObject exampleObject1;

    @Mock
    private ExampleObject exampleObject2;

    private CurriedBiFunction<ExampleObject, ExampleObject, Map<ExampleObject, ExampleObject>> biFunction;

    @BeforeEach
    void setup() {
        biFunction = Collections::singletonMap;
        Assume.assumeThat(biFunction.apply(exampleObject1, exampleObject2), IsMapContaining.hasEntry(exampleObject1, exampleObject2));
    }

    @Test
    void curryWithOneParameter() {
        //prepare

        //execute
        CurriedFunction<ExampleObject, Map<ExampleObject, ExampleObject>> function = biFunction.curry(exampleObject1);

        //verify
        Assert.assertThat(function.apply(exampleObject2), IsMapContaining.hasEntry(exampleObject1, exampleObject2));
    }

    @Test
    void curryWithTwoParameters() {
        //prepare

        //execute
        Supplier<Map<ExampleObject, ExampleObject>> supplier = biFunction.curry(exampleObject1, exampleObject2);

        //verify
        Assert.assertThat(supplier.get(), IsMapContaining.hasEntry(exampleObject1, exampleObject2));
    }
}