package com.nana.arrays;

public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int [] {5,4,-1,7,8}));
    }

    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and return its sum.
     * A subarray is a contiguous part of an array.
     * @param array
     * @return
     */
    public static int maxSubArray(int[] array) {
        int maxNearEnding = array[0];
        int maxHereSoFar = array[0];

        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            maxNearEnding = Math.max(num, maxNearEnding + num);
            maxHereSoFar = Math.max(maxHereSoFar, maxNearEnding);
        }
        return maxHereSoFar;
    }
}
