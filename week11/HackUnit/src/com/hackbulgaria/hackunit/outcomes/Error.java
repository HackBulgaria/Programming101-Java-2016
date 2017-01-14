package com.hackbulgaria.hackunit.outcomes;

public class Error extends Outcome {

    private Exception e;

    public Error(Class cls, Exception e) {
        super(cls);
        this.e = e;
    }

    @Override
    String getMessage() {
        return String.format("Error in %s: %s", getCls().toString(), e.toString());
    }
}
