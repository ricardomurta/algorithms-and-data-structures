package patterns.frequencycounter;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagramArray("Hello!", "oll!eh"));
        System.out.println(isAnagramHashMap("Hello!", "oll!eh"));
        System.out.println(isAnagram01("Hello!", "ol!ehl"));
        System.out.println(isAnagram02("Hello!  123", "ol1!   ehl 3   2 "));
    }

    public static boolean isAnagramHashMap(String str1, String str2) {
        // Handle edge cases: different lengths or empty strings
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert both strings to lowercase
        String s1 = str1.toLowerCase();
        String s2 = str2.toLowerCase();

        // Create a HashMap to store character frequencies
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Iterate through second string and check if characters and frequencies match
        for (char c : s2.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }

        // If all characters and frequencies match, it's an anagram
        return true;
    }

    public static boolean isAnagramArray(String str1, String str2) {
        // Handle edge cases: different lengths or empty strings
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert both strings to lowercase and remove whitespaces
        String s1 = str1.toLowerCase().replaceAll("\\s", "");
        String s2 = str2.toLowerCase().replaceAll("\\s", "");

        // Create a character count array to store frequencies
        int[] charCount = new int[256];
        for (char c : s1.toCharArray()) {
            charCount[c]++;
        }

        // Iterate through second string and check if characters and frequencies match
        for (char c : s2.toCharArray()) {
            if (charCount[c] == 0) {
                return false;
            }
            charCount[c]--;
        }

        // If all characters and frequencies match, it's an anagram
        return true;
    }

    public static boolean isAnagram01(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char c : str1.toLowerCase().replaceAll("\\s", "").toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : str2.toLowerCase().replaceAll("\\s", "").toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> itemMap1 : map1.entrySet()) {
            Integer valueMap2 = map2.get(itemMap1.getKey());
            if (valueMap2 == null || !valueMap2.equals(itemMap1.getValue())) return false;
        }
        return true;
    }

    public static boolean isAnagram02(String str1, String str2) {
        str1 = str1.toLowerCase().replaceAll("\\s", "");
        str2 = str2.toLowerCase().replaceAll("\\s", "");
        if (str1.length() != str2.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : str2.toCharArray()) {
            if (!map.containsKey(c) || map.get(c).equals(0)) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
//            if (map.containsKey(c) && map.get(c).compareTo(0) > 0) {
//                map.put(c, map.get(c) - 1);
//            } else {
//                return false;
//            }
        }
        return true;
    }
}
