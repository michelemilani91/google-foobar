package it.milani.p01;

import java.util.Arrays;

public class Solution {
    /**
        Write a function called solution(s) that, given a non-empty string less than 200 characters in length describing
        the sequence of M&Ms, returns the maximum number of equal parts that can be cut from the cake without leaving
        any leftovers.
     */
    public static int solution(String x) {
        if (x.length() == 0 || x.length() > 200 || !x.matches("^[a-z]*$"))
            return 0;
        final StringBuilder charSequence = new StringBuilder();
        for (int i = 0; i <= x.length() / 2; i++) {
            charSequence.append(x.charAt(i));
            final String[] repeatSet = x.split("(?<=\\G.{" + charSequence.length() + "})");
            final boolean isTheRightSequence = Arrays.stream(repeatSet).allMatch(s -> s.equals(repeatSet[0]))
                    && repeatSet.length * charSequence.length() == x.length();
            if (isTheRightSequence)
                return repeatSet.length;
        }
        return 1;
    }

}