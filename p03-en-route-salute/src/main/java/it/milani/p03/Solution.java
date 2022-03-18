package it.milani.p03;

public class Solution {

    private static final char LEFT = '<';
    private static final char RIGHT = '>';

    public static int solution(String s) {
        // check constraints
        if (s.length() < 1 || s.length() > 100 || !s.matches("[<>-]*"))
            throw new IllegalArgumentException("String not valid");

        int salutes = 0;
        for (int i = 0; i < s.length(); i++) {
            final char direction = s.charAt(i);
            if (direction == RIGHT) {
                salutes += 2 * s.substring(i).chars().filter(ch -> ch == LEFT).count();
            }
        }
        return salutes;
    }
}