package com.hackbulgaria.hackunit.outcomes;

public abstract class Outcome {
    private Class cls;

    public Class getCls() {
        return cls;
    }

    public Outcome(Class cls) {
        this.cls = cls;
    }

    abstract String getMessage();

    @Override
    public String toString() {
        return getMessage();
    }
}
