package com.hackbulgaria.hackunit;

import com.hackbulgaria.hackunit.outcomes.Failure;
import com.hackbulgaria.hackunit.outcomes.Outcome;
import com.hackbulgaria.hackunit.outcomes.Success;
import com.hackbulgaria.hackunit.outcomes.Error;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private List<Success> successes = new ArrayList<>();
    private List<Failure> failures = new ArrayList<>();
    private List<Error> errors = new ArrayList<>();
    private List<Outcome> outcomes = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Results: [");

        successes.forEach(s -> sb.append("✓"));
        failures.forEach(s -> sb.append("X"));
        errors.forEach(s -> sb.append("E"));

        sb.append("]\n");

        if (!failures.isEmpty()) {
            sb.append("\nFailures:\n");
            failures.forEach(f -> sb.append(f.toString()).append("\n"));
        }

        if (!errors.isEmpty()) {
            sb.append("\nErrors:\n");
            errors.forEach(e -> sb.append(e.toString()).append("\n"));
        }

        return sb.toString();
    }

    private void addOutcome(Outcome o) {
        outcomes.add(o);
    }

    public void add(Success s) {
        successes.add(s);
        addOutcome(s);
    }

    public void add(Failure f) {
        failures.add(f);
        addOutcome(f);
    }

    public void add(Error e) {
        errors.add(e);
        addOutcome(e);
    }

    public List<Success> getSuccesses() {
        return successes;
    }

    public List<Failure> getFailures() {
        return failures;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public List<Outcome> getOutcomes() {
        return outcomes;
    }
}
