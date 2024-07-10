package patterns.frequencycounter;

import java.util.HashMap;
import java.util.Map;

public class SameFrequency {
    /*
    Write a function called sameFrequency.
    Given two positive integers, find out if the two numbers have the same frequency of digits.
    Your solution MUST have the following complexities:
    Time: O(N)
    Sample Input:
    sameFrequency(182,281) // true
    sameFrequency(34,14) // false
    sameFrequency(3589578, 5879385) // true
    sameFrequency(22,222) // false
    */

    public static boolean frequencyCounter(int n1, int n2) {
        String s1 = String.valueOf(n1);
        String s2 = String.valueOf(n2);

        if (s1.length() != s2.length())
            return false;

        Map<Character, Integer> fc = new HashMap<>();
        for (char c : s1.toCharArray()) {
            fc.put(c, fc.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            if (fc.get(c) == null || fc.get(c).equals(0)) return false;
            fc.put(c, fc.get(c) - 1);
        }
        return true;
    }

}
