package com.Boonprakob.Thanaphon;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void testMethod()
    {
        String s[] = {"First String","second string"};
        App.main(s);
    }
}
