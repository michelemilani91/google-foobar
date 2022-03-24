package it.milani.p04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void checkExample1() {
        final int result = Solution.solution(new int[][]{
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {1, 1, 0, 0},
                {1, 1, 1, 0}
        });
        assertEquals(7, result);
    }

    @Test
    public void checkExample2() {
        final int result = Solution.solution(new int[][]{
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        });
        assertEquals(11, result);
    }

    @Test
    public void checkExample3() {
        final int result = Solution.solution(new int[][]{
                { 0, 0, 0, 1, 0 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 1, 0 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0 }
        });
        assertEquals(9, result);
    }
}