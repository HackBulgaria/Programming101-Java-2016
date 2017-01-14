package com.hackbulgaria;

import com.hackbulgaria.hackunit.HackUnitCore;
import com.hackbulgaria.hackunit.Results;
import com.hackbulgaria.hackunit.tests.MyTests;

public class Main {

    public static void main(String[] args) {
        Results results = new HackUnitCore()
                .runClasses(MyTests.class)
                .getResults();

        System.out.println(results);
    }

}
