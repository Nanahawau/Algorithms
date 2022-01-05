package com.nana.strings;

public class RotationalCipher {
    
    public static void main(String[] args) {
        System.out.println(rotationalCipher("Zebra-493?", 3));
    }

      
  static boolean isNumeric(Character value) {
    return Character.isDigit(value);
  }
 
  static String rotationalCipher(String input, int rotationFactor) {
    // Write your code here
       StringBuilder b = new StringBuilder();

    for (int i = 0; i < input.length(); i++) { 

      if (!isNumeric(input.charAt(i))) {
          
      if (Character.isUpperCase(input.charAt(i))) {
           int value = ((((int)input.charAt(i) + rotationFactor)  - 65)  % 26) + 65;
           char ch = (char) value;
           b.append(ch);
      } else if (!Character.isLetterOrDigit(input.charAt(i))) {
           b.append(input.charAt(i));
      }else {
          int value = ((((int)input.charAt(i) + rotationFactor)  - 97)  % 26) + 97;
          char ch = (char) value;
          b.append(ch);
      }
    } else {
      int value = ((((int)input.charAt(i) + rotationFactor)  - 48)  % 10) + 48;
      char ch = (char) value;
      b.append(ch);
    } 
  } 
    return b.toString();
  }
}
