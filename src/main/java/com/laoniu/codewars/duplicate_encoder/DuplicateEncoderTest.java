package com.laoniu.codewars.duplicate_encoder;

import com.laoniu.codewars.duplicate_encoder.DuplicateEncoder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DuplicateEncoderTest {
    @Test
    public void test() {
      assertEquals(")()())()(()()(",
            DuplicateEncoder.encode("Prespecialized"));
      assertEquals("))))())))",DuplicateEncoder.encode("   ()(   "));
    }
}