package com.laoniu.codewars.Numbers_that_are_a_power_of_their_sum_of_digits;

public class PowerSumDig {
    public static int sumBit(int n) {
        return n < 10 ? n : n % 10 + sumBit(n / 10);
    }

    public static int countBit(int n) {
        return n < 10 ? 1 : 1 + countBit(n / 10);
    }

    public static int pow(int n, int pow) {
        return pow == 0 ? 1 : n * pow(n, pow - 1);
    }

    public static boolean isPowerSumDigTerm(int n) {
        int sum = sumBit(n);
        if(sum==1){
            return false;
        }
        for (int i = 2; ; i++) {
            int sumPow = pow(sum, i);
            if (sumPow == n) {
                return true;
            }
            if (sumPow > n) {
                return false;
            }
        }
    }

    public static long powerSumDigTerm(int n) {
        for (int i = 10, count = 0; ; i++) {
            if (isPowerSumDigTerm(i)) {
                count++;
            }
            if (count == n) {
                return i;
            }
        }
    }
}