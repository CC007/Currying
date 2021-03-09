package com.github.cc007.currying.function.curried;

import com.github.cc007.currying.ExampleObject;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.Supplier;

@ExtendWith(MockitoExtension.class)
class CurriedFunctionTest {

    @Mock
    private ExampleObject exampleObject;

    @Test
    void curry() {
        //prepare
        CurriedFunction<ExampleObject, ExampleObject> function = (ExampleObject obj) -> obj;
        Assume.assumeThat(function.apply(exampleObject), IsEqual.equalTo(exampleObject));

        //execute
        Supplier<ExampleObject> supplier = function.curry(exampleObject);

        //verify
        Assert.assertThat(supplier.get(), IsEqual.equalTo(exampleObject));
    }
}