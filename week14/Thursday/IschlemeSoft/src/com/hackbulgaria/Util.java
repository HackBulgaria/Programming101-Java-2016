package com.hackbulgaria;

public class Util {
    public static void threadMessage(String msg) {
        System.out.format("%s: %s%n", Thread.currentThread().getName(), msg);
    }
}
