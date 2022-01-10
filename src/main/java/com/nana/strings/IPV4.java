package com.nana.strings;

import java.util.Arrays;

/**
 * IPV4 validation
 */
public class IPV4 {

  public static void main(String[] args) {
    System.out.println(validateIP(".254.255.0"));
  }

  static boolean validateString(String s) {
    System.out.println(s);
    int value = 0;
    try {
      value = Integer.parseInt(s);
      if (value >= 0 && value <= 255) {
        return true;
      } 
    } catch (NumberFormatException ex) {
    }
    return false;
  }

  static boolean leadingZeros(String s) {
    boolean leadingZero = false;
    if (s.length() > 1) {
      leadingZero = s.charAt(0) == 0 ? true : false;
    }
    return leadingZero;
  }

  static boolean validateIP(String ip) {
    System.out.println(ip);

    boolean isIPV4 = false;
    boolean hasLeadingZeros = false;

    // split string using dot.
    String[] splittedString = ip.split("\\.");

    // check if length is more than 4;
    if (splittedString.length > 4) {
      return false;
    }

    for (String s : splittedString) {

      isIPV4 = validateString(s);
      hasLeadingZeros = leadingZeros(s);

      if (!isIPV4 || hasLeadingZeros) {
        return false;
      }
    }   
    return true;
  }
  
}