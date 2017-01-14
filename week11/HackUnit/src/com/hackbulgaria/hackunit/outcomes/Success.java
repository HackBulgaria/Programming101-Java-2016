package com.hackbulgaria.hackunit.outcomes;

import java.lang.reflect.Method;

/**
 * Created by plamen on 12.01.17.
 */
public class Success extends Outcome {

    private Method method;

    public Success(Class cls, Method method) {
        super(cls);
        this.method = method;
    }

    @Override
    String getMessage() {
        return String.format("Success in %s, method %s", getCls().toString(), method.toString());
    }
}
