package com.hackbulgaria.hackunit.tests;

import com.hackbulgaria.hackunit.Assert;
import com.hackbulgaria.hackunit.Test;

public class MyTests {

    @Test
    public void onePlusOneShouldBeTwo() {
        Assert.assertTrue(1 + 1 == 2);
    }

    @Test
    public void falseIsTrue() {
        Assert.assertTrue("Why isn't true false???", true == false);
    }

    @Test
    public void oops() {
        throw new RuntimeException("Oops");
    }

    @Test
    public void multiplicationByZeroShouldBeZero() {
        Assert.assertTrue("Maths pls", 123 * 0 == 1);
    }
}
