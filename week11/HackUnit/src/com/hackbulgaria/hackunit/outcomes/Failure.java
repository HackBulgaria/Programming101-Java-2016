package com.hackbulgaria.hackunit.outcomes;

import java.lang.reflect.Method;

public class Failure extends Outcome {

    private Method method;
    private AssertionError error;

    public Failure(Class cls, Method method, AssertionError error) {
        super(cls);
        this.method = method;
        this.error = error;
    }

    @Override
    String getMessage() {
        String message = error.getMessage() == null ? "" : error.getMessage();

        return String.format("Failure in %s, method %s: %s",
                getCls().toString(),
                method.toString(),
                message);
    }
}
