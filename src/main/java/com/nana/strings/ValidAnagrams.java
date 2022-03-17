package com.nana.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagrams {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagramSorted("anagram", "nagaram"));
    }

    /**
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c) && map.get(c) - 1 == 0) {
                map.remove(c);
            } else if (map.containsKey(c) && map.get(c) - 1 > 0) {
                map.put(c, map.get(c) - 1);
            }else {
                return false;
            }
        }
        return map.size() == 0;
    }

    /**
     * TC : o(log n) sorting twice
     * SC: o(n)
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagramSorted(String s, String t) {
        if (s.length() != t.length()) return false;

        char [] c1 = s.toCharArray();
        char [] c2 = t.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);
    }


}
