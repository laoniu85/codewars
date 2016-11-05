package com.laoniu.codewars.factorial;

public class Factorial {
    public int factorial(int n) {
        if (n < 0 || n > 12) throw new IllegalArgumentException("should not lower than 0");
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

}