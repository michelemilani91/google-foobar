package it.milani.p02;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void testExample1() {
        final int[] solution = Solution.solution(new int[]{4, 17, 50});
        assertArrayEquals(new int[]{-1, -1}, solution);
    }

    @Test
    public void testExample2() {
        final int[] solution = Solution.solution(new int[]{4, 30, 50});
        assertArrayEquals(new int[]{12, 1}, solution);
    }
}