package com.nana.misc;

public class TopTalQuestions {

    public static void main(String[] args) {
        System.out.println(numberOfCarry(1, 99999));
    }

    /**
     * numberOfCarryOperations(123, 456) // 0
     * numberOfCarryOperations(555, 555) // 3
     * numberOfCarryOperations(900, 11) // 0
     * numberOfCarryOperations(145, 55) // 2
     * numberOfCarryOperations(0, 0) // 0
     * numberOfCarryOperations(1, 99999) // 5
     * numberOfCarryOperations(999045, 1055) // 5
     * numberOfCarryOperations(101, 809) // 1
     * @param a
     * @param b
     * @return
     */
    static int numberOfCarry (int a , int b) {
        int counter = 0;
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;

            counter += Integer.bitCount(b);
        }
        return counter;
    }

    /**
     * getChange(5, 0.99) // should return [1,0,0,0,0,4]
     * getChange(3.14, 1.99) // should return [0,1,1,0,0,1]
     * getChange(3, 0.01) // should return [4,0,2,1,1,2]
     * getChange(4, 3.14) // should return [1,0,1,1,1,0]
     * getChange(0.45, 0.34) // should return [1,0,1,0,0,0]
     * @param a
     * @param b
     * @return
     */
//    static int change (int a , int b) {
//
//    }

    /**
     * findWord(["U>N", "G>A", "R>Y", "H>U", "N>G", "A>R"]) // HUNGARY
     * findWord(["I>F", "W>I", "S>W", "F>T"]) // SWIFT
     * findWord(["R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G"]) // PORTUGAL
     * findWord(["W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T"]) // SWITZERLAND
     * @param a
     * @param b
     * @return
     */
//    static int words (int a , int b) {
//
//    }
}
