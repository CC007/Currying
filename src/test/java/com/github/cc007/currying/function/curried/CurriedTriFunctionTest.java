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

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@ExtendWith(MockitoExtension.class)
class CurriedTriFunctionTest {

    @Mock
    private ExampleObject exampleObject1;

    @Mock
    private ExampleObject exampleObject2;

    @Mock
    private ExampleObject exampleObject3;

    private CurriedTriFunction<ExampleObject, ExampleObject, ExampleObject, Map<ExampleObject, ExampleObject>> triFunction;

    @BeforeEach
    void setup() {
        triFunction = (ExampleObject obj1, ExampleObject obj2, ExampleObject obj3) -> {
            Map<ExampleObject, ExampleObject> map = new HashMap<>();
            map.put(obj1, obj2);
            map.put(obj2, obj3);
            return map;
        };
        Map<ExampleObject, ExampleObject> resultMap = triFunction.apply(exampleObject1, exampleObject2, exampleObject3);
        Assume.assumeThat(resultMap, IsMapContaining.hasEntry(exampleObject1, exampleObject2));
        Assume.assumeThat(resultMap, IsMapContaining.hasEntry(exampleObject2, exampleObject3));
    }

    @Test
    void curryWithOneParameter() {
        //prepare

        //execute
        CurriedBiFunction<ExampleObject, ExampleObject, Map<ExampleObject, ExampleObject>> biFunction = triFunction.curry(exampleObject1);

        //verify
        Map<ExampleObject, ExampleObject> resultMap = biFunction.apply(exampleObject2, exampleObject3);
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject1, exampleObject2));
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject2, exampleObject3));
    }

    @Test
    void curryWithTwoParameter() {
        //prepare

        //execute
        CurriedFunction<ExampleObject, Map<ExampleObject, ExampleObject>> function = triFunction.curry(exampleObject1, exampleObject2);

        //verify
        Map<ExampleObject, ExampleObject> resultMap = function.apply(exampleObject3);
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject1, exampleObject2));
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject2, exampleObject3));
    }

    @Test
    void curryWithThreeParameters() {
        //prepare

        //execute
        Supplier<Map<ExampleObject, ExampleObject>> supplier = triFunction.curry(exampleObject1, exampleObject2, exampleObject3);

        //verify
        Map<ExampleObject, ExampleObject> resultMap = supplier.get();
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject1, exampleObject2));
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject2, exampleObject3));
    }
}