package patterns.frequencycounter;

import java.util.HashMap;
import java.util.Map;

public class AreThereDuplicates {
    /*
    Implement a function called, areThereDuplicates which accepts a variable number of arguments,
    and checks whether there are any duplicates among the arguments passed in.
    You can solve this using the frequency counter pattern OR the multiple pointers pattern.
    Examples:
    areThereDuplicates(1, 2, 3) // false
    areThereDuplicates(1, 2, 2) // true
    areThereDuplicates('a', 'b', 'c', 'a') // true
    Restrictions:
    Time - O(n)
    Space - O(n)
    Bonus:
    Time - O(n log n)
    Space - O(1)
    * */
    public static boolean areThereDuplicates(char ...args) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char arg : args) {
            Integer count = charMap.getOrDefault(arg, 0) + 1;
            if (count.compareTo(1) > 0)
                return true;
            charMap.put(arg, count);
        }
        return false;
    }
}
