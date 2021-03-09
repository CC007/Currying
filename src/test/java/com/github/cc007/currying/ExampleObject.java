package com.github.cc007.currying;

/**
 * A class that can be used as a mock
 */
public class ExampleObject {

    public void foo() {
    }

    public ExampleObject fiveParameterFunction(ExampleObject obj1, ExampleObject obj2, ExampleObject obj3, ExampleObject obj4, ExampleObject obj5) {
        return this;
    }

    public void fiveParameterConsumer(ExampleObject obj1, ExampleObject obj2, ExampleObject obj3, ExampleObject obj4, ExampleObject obj5) {
    }
}
