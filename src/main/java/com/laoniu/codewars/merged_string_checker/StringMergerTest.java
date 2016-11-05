package com.laoniu.codewars.merged_string_checker;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringMergerTest {

    @Test
    public void normalHappyFlow() {
        assertTrue("codewars can be created from code and wars", StringMerger.isMerge("codewars", "code", "wars"));
        assertTrue("codewars can be created from cdwr and oeas", StringMerger.isMerge("codewars", "cdwr", "oeas"));
        assertFalse("Codewars are not codwars", StringMerger.isMerge("codewars", "cod", "wars"));
        assertTrue( StringMerger.isMerge("p1:?!qOY1Kut!Y7gbs&lt;J5;'2ep1:?!qOY1Kut!Y[&$PUM99I#l^H%'!1m\nfp","p1:?!qOY1Kut!Y[&$PUM99I#","p1:?!qOY1Kut!Y7gbs&lt;J5;'2el^H%'!1m\nfp"));



    }

}