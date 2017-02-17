package com.hackbulgaria.signalling;

public class Util {
    public static void threadMsg(String msg) {
        System.out.format("%s: %s%n", Thread.currentThread().getName(), msg);
    }
}
