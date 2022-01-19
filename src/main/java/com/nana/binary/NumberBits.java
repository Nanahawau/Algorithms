package com.nana.binary;

public class NumberBits {
    public static void main(String[] args) {
//        hammingWeight(11111111111111111111111111111101);
    }

    /**
     * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
     * Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type.
     * It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
     * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer.
     * -3.
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int count = 0;
        String v = String.valueOf(n);

        for (int i = 0; i < v.length(); i++) {
            if (v.charAt(i) == '1')
                count += 1;
        }
        return count;
    }
}
