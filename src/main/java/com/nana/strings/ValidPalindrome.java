package com.nana.strings;

public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder stringWithoutCharacters = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (Character.isLetterOrDigit(c))
            stringWithoutCharacters.append(c);
        }

        String original = stringWithoutCharacters.toString();
        String reversed = stringWithoutCharacters.reverse().toString();

        return original.equalsIgnoreCase(reversed);
    }

}
