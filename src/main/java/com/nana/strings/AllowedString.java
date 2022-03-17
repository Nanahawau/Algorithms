package com.nana.strings;

public class AllowedString {
    public static void main(String[] args) {
        System.out.println(allowedString("Codility We are Coders", 1));
    }

    public static String allowedString (String message, int K) {
        String [] s = message.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int currentAllowedStringLength = 0;

        if (s[0].length() <= K) {
            stringBuilder.append(s[0]);
            stringBuilder.append(" ");
            currentAllowedStringLength += s[0].length() + 1;
        }

        for (int i = 1; i < s.length; i++) {
            int individualLength = s[i].length();
            int diff = K - currentAllowedStringLength;

            if (individualLength <= diff) {
                stringBuilder.append(s[i]);
                stringBuilder.append(" ");
                currentAllowedStringLength += s[i].length() + 1;
            }
        }
        return stringBuilder.toString().length() > 0 ? stringBuilder.toString().trim() : " ";
    }
}
