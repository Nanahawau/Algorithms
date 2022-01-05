package com.nana.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        
    }


    // recursively
    public static List<char[]> combinations(char[] data) {
        List<char[]> combinations = new ArrayList<>();
        if (data == null) return combinations;
        if (data.length == 0) {
            combinations.add(new char[0]);
            return combinations;
        }
        char first = data[0];
        List<char[]> rest = combinations(Arrays.copyOfRange(data, 1, data.length));
        combinations.addAll(rest);
    
        for (char[] combo : rest) {
            char[] copy = new char[combo.length + 1];
            copy[0] = first;
            System.arraycopy(combo, 0, copy, 1, combo.length);
            combinations.add(copy);
        }
        return combinations;
    } 
}
