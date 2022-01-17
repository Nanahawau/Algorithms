package com.nana.arrays;

public class MaxProductArray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[] {2,3,-2, 4}));
    }

    /**
     * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product,
     * and return the product.
     * The test cases are generated so that the answer will fit in a 32-bit integer.
     * A subarray is a contiguous subsequence of the array.
     * Negative numbers make the Kadane algo not work.
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int productPerIteration = nums[0];
        int finalProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            productPerIteration = Math.max(num, Math.abs(num * productPerIteration));
            finalProduct = Math.max(productPerIteration, finalProduct);
        }
        return finalProduct;
    }
}




