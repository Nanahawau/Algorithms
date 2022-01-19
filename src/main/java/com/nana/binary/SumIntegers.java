package com.nana.binary;

public class SumIntegers {
    public static void main(String[] args) {
        System.out.println(getSum(1, 3));
    }

    /**
     * https://www.youtube.com/watch?v=qq64FrA2UXQ
     * Given two integers a and b, return the sum of the two integers without using the operators + and -.
     * @param a
     * @param b
     * @return
     */
    public static int getSum(int a, int b) {

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }


    public static int getSub (int a , int b) {
        while (b != 0) {
            int borrow = (~a) & b;
             a = a ^ b;
             b = borrow << 1;
        }
        return a;
    }

}
