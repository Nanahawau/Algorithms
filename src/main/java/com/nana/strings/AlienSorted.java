package com.nana.strings;

import java.util.HashMap;
import java.util.Map;

public class AlienSorted {
    public static void main(String[] args) {
        
    }


    /**
     * In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
     * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.
     * @param words
     * @param order
     * @return
     */

    static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> indexByChar = getIndexMap(order);
        
        for (int i = 0; i + 1 < words.length; i++) {
            String current = words[i];
            String next = words[i + 1];
            int matchCount = 0;
            int minLen = Math.min(current.length(), next.length());
    
            for (int j = 0; j < minLen; j++) {
                int index1 = indexByChar.get(current.charAt(j));
                int index2 = indexByChar.get(next.charAt(j));
                
                if (index1 < index2)
                    break;
                if (index1 > index2)
                    return false;
                matchCount++;
            }
            if (matchCount == minLen && current.length() > next.length())
                return false;
        }
        
        return true;
    }
    
    static HashMap<Character, Integer> getIndexMap(String order) {
        HashMap<Character, Integer> indexByChar = new HashMap<Character, Integer>();
        for (int i = 0; i < order.length(); i++)
            indexByChar.put(order.charAt(i), i);
        return indexByChar;
    }
}
