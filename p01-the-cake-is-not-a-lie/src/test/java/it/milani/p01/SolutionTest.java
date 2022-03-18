package it.milani.p01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testExample1() {
        final int solution = Solution.solution("abcabcabcabc");
        assertEquals(4, solution);
    }

    @Test
    public void testExample2() {
        final int solution = Solution.solution("abccbaabccba");
        assertEquals(2, solution);
    }

    @Test
    public void evaluatesOneCharacter() {
        final int solution = Solution.solution("a");
        assertEquals(1, solution);
    }

    @Test
    public void evaluatesSimpleExpression2() {
        final int solution = Solution.solution("abcabcabcabca");
        assertEquals(1, solution);
    }
}
