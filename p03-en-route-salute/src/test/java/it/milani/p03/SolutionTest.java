package it.milani.p03;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void checkExample1() {
        final int result = Solution.solution("--->-><-><-->-");
        assertEquals(10, result);
    }

    @Test
    public void checkExample2() {
        final int result = Solution.solution(">----<");
        assertEquals(2, result);
    }

    @Test
    public void checkExample3() {
        final int result = Solution.solution("<<>><");
        assertEquals(4, result);
    }
}
