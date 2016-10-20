package com.hackbulgaria.programming51.week3;

public class Arr {
  public static String toString(int[] a) {
    return "";
  }
  
  public static void sort(int[] a) {
    
  }
  
  public static int[] reverse(int[] a) {
    return new int[a.length];
  }
  
  public static String join(int[] a, String glue) {
    return "";
  }
  
  public static int sum(int[] a) {
    return 0;
  }
  
  public static int[] range(int a, int b) {
    return new int[Math.abs(b - a)];
  }
  
  public static int[] filterOdd(int[] a) {
    return new int[a.length];
  }
  
  public static void main(String[] args) {
    int[] a = {10, 20, -50, 80, 70, 66, -365};

    System.out.println("Print the array to string:");
    System.out.println(Arr.toString(a));
    
    System.out.println("Sort the array a itself and print it sorted:");
    Arr.sort(a);
    System.out.println(Arr.toString(a));
    
    
    System.out.println("Print the reverse of the sorted array");
    System.out.println(Arr.reverse(a));
    
    System.out.println("Output each element in a with -> between them");
    System.out.println(Arr.join(a, "->"));
    
    System.out.println("Output the sum");
    System.out.println(Arr.sum(a));
    
    System.out.println("Output array with elements from 1 to 10");
    System.out.println(Arr.toString(Arr.range(1, 10)));
    
    System.out.println("Print only the odd numbers");
    System.out.println(Arr.filterOdd(a));
  }
}
