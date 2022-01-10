// package com.nana.misc;

// import java.util.ArrayList;
// import java.util.List;

// public class Permutations {
//     public static void main(String[] args) {
         
//     }

//     private static List<List<Character>> permutations(char[] aChars) {
//         return permutations(aChars, aChars.length - 1);
//     }
    
//     private static List<List<Character>> permutations(char[] aChars, int aIdx) {
//         List<List<Character>> permutations = new ArrayList<>();
//         if (aChars.length == 0) {
//             return permutations;
//         }
//         if (aIdx == 0) {
//             permutations.add(List.of(aChars[0]));
//             return permutations;
//         }
    
//    char ch = aChars[aIdx];
//     List<List<Character>> subPerms = permutations(aChars, aIdx - 1);

//     for (List<Character> p : subPerms) {
//         for (int i = 0; i <= p.size(); i++) {
//             List<Character> cp = new ArrayList<>(p);
//             cp.addAll(i, List.of(ch));
//             permutations.add(cp);
//         }
//     }
//     return permutations;
// }
// }
