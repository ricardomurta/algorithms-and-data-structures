package patterns.twopointers;

public class IsSubsequence2 {
    /*
Write a function called isSubsequence which takes in two strings and checks whether the characters
in the first string form a subsequence of the characters in the second string. In other words,
the function should check whether the characters in the first string appear somewhere in the second string,
without their order changing.
Examples:
isSubsequence('hello', 'hello world'); // true
isSubsequence('sing', 'sting'); // true
isSubsequence('abc', 'abracadabra'); // true
isSubsequence('abc', 'acb'); // false (order matters)
Your solution MUST have AT LEAST the following complexities:
Time Complexity - O(N + M)
Space Complexity - O(1)
    */

    public static void main(String[] args) {
        System.out.println(isSubsequence("hello", "hello world"));
        System.out.println(isSubsequence("sing", "sting"));
        System.out.println(isSubsequence("abc", "abracadabra"));
        System.out.println(isSubsequence("abc", "acb"));
    }

    public static boolean isSubsequence(String str1, String str2) {
        if (str1.length() > str2.length())
            return false;
        int i = 0, j = 0;
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        while (j < charArray2.length) {
            if (charArray1[i] == charArray2[j]) {
                if (i == charArray1.length - 1) return true;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return false;
    }
}
