package com.hackbulgaria;

public enum Skill {
    CODE_MONKEY(7.5),
    NOVICE(3.5),
    JUNIOR(1),
    SENIOR(0.25);

    private double multiplier;

    Skill(double multiplier) {
        this.multiplier = multiplier;
    }

    public double multiplier() {
        return multiplier;
    }
}
