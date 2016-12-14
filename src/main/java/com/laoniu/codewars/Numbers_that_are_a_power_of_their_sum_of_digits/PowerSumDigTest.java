package com.laoniu.codewars.Numbers_that_are_a_power_of_their_sum_of_digits;

import static org.junit.Assert.*;
import org.junit.Test;

public class PowerSumDigTest {

    private static void testing(long act, long exp) {
        assertEquals(exp, act);
    }
    @Test
    public void test1() {
        testing(PowerSumDig.powerSumDigTerm(1), 81);
        testing(PowerSumDig.powerSumDigTerm(2), 512);
        testing(PowerSumDig.powerSumDigTerm(3), 2401);
        testing(PowerSumDig.powerSumDigTerm(4), 4913);
    }

    @Test
    public void test2(){
        assertEquals(17,PowerSumDig.sumBit(4913));
        assertEquals(4,PowerSumDig.countBit(4913));
        assertEquals(PowerSumDig.pow(17,3),4913);
    }
}