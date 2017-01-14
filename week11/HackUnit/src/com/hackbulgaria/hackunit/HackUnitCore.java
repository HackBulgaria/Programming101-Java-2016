package com.hackbulgaria.hackunit;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.hackbulgaria.hackunit.outcomes.Error;
import com.hackbulgaria.hackunit.outcomes.Failure;
import com.hackbulgaria.hackunit.outcomes.Success;

public class HackUnitCore {

    private Results results = new Results();

    public Results getResults() {
        return results;
    }

    public HackUnitCore runClasses(Class... classes) {

        for (Class<?> cls : classes) {

            Constructor<?> constructor;
            try {
                constructor = cls.getConstructor();
            } catch (NoSuchMethodException e) {
                results.add(new Error(cls, e));
                continue;
            }

            Method[] methods = cls.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class)) {
                    try {
                        Object obj = constructor.newInstance();
                        try {
                            method.invoke(obj);
                            results.add(new Success(cls, method));
                        } catch (InvocationTargetException e) {
                            Throwable cause = e.getCause();
                            if (cause instanceof AssertionError) {
                                results.add(new Failure(cls, method, (AssertionError) cause));
                            } else if (cause instanceof Exception) {
                                results.add(new Error(cls, (Exception) cause));
                            } else {
                                throw new IllegalStateException();
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return this;
    }
}
