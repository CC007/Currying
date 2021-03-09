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
class CurriedQuintFunctionTest {

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

    private CurriedQuintFunction<ExampleObject, ExampleObject, ExampleObject, ExampleObject, ExampleObject, Map<ExampleObject, ExampleObject>> quadFunction;

    @BeforeEach
    void setup() {
        quadFunction = (ExampleObject obj1, ExampleObject obj2, ExampleObject obj3, ExampleObject obj4, ExampleObject obj5) -> {
            Map<ExampleObject, ExampleObject> map = new HashMap<>();
            map.put(obj1, obj2);
            map.put(obj2, obj3);
            map.put(obj3, obj4);
            map.put(obj4, obj5);
            return map;
        };
        Map<ExampleObject, ExampleObject> resultMap = quadFunction.apply(exampleObject1, exampleObject2, exampleObject3, exampleObject4, exampleObject5);
        Assume.assumeThat(resultMap, IsMapContaining.hasEntry(exampleObject1, exampleObject2));
        Assume.assumeThat(resultMap, IsMapContaining.hasEntry(exampleObject2, exampleObject3));
        Assume.assumeThat(resultMap, IsMapContaining.hasEntry(exampleObject3, exampleObject4));
        Assume.assumeThat(resultMap, IsMapContaining.hasEntry(exampleObject4, exampleObject5));
    }

    @Test
    void curryWithOneParameter() {
        //prepare

        //execute
        CurriedQuadFunction<ExampleObject, ExampleObject, ExampleObject, ExampleObject, Map<ExampleObject, ExampleObject>> biFunction = quadFunction.curry(exampleObject1);

        //verify
        Map<ExampleObject, ExampleObject> resultMap = biFunction.apply(exampleObject2, exampleObject3, exampleObject4, exampleObject5);
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject1, exampleObject2));
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject2, exampleObject3));
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject3, exampleObject4));
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject4, exampleObject5));
    }

    @Test
    void curryWithTwoParameter() {
        //prepare

        //execute
        CurriedTriFunction<ExampleObject, ExampleObject, ExampleObject, Map<ExampleObject, ExampleObject>> biFunction = quadFunction.curry(exampleObject1, exampleObject2);

        //verify
        Map<ExampleObject, ExampleObject> resultMap = biFunction.apply(exampleObject3, exampleObject4, exampleObject5);
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject1, exampleObject2));
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject2, exampleObject3));
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject3, exampleObject4));
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject4, exampleObject5));
    }

    @Test
    void curryWithThreeParameter() {
        //prepare

        //execute
        CurriedBiFunction<ExampleObject, ExampleObject, Map<ExampleObject, ExampleObject>> biFunction = quadFunction.curry(exampleObject1, exampleObject2, exampleObject3);

        //verify
        Map<ExampleObject, ExampleObject> resultMap = biFunction.apply(exampleObject4, exampleObject5);
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject1, exampleObject2));
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject2, exampleObject3));
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject3, exampleObject4));
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject4, exampleObject5));
    }

    @Test
    void curryWithFourParameters() {
        //prepare

        //execute
        CurriedFunction<ExampleObject, Map<ExampleObject, ExampleObject>> function = quadFunction.curry(exampleObject1, exampleObject2, exampleObject3, exampleObject4);

        //verify
        Map<ExampleObject, ExampleObject> resultMap = function.apply(exampleObject5);
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject1, exampleObject2));
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject2, exampleObject3));
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject3, exampleObject4));
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject4, exampleObject5));
    }

    @Test
    void curryWithFiveParameters() {
        //prepare

        //execute
        Supplier<Map<ExampleObject, ExampleObject>> supplier = quadFunction.curry(exampleObject1, exampleObject2, exampleObject3, exampleObject4, exampleObject5);

        //verify
        Map<ExampleObject, ExampleObject> resultMap = supplier.get();
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject1, exampleObject2));
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject2, exampleObject3));
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject3, exampleObject4));
        Assert.assertThat(resultMap, IsMapContaining.hasEntry(exampleObject4, exampleObject5));
    }

}