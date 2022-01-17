package com.nana.arrays;

import java.util.Arrays;

public class ProductArrayWithoutSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));
    }

    /**
     * Given an integer array nums, return an array answer such that answer[i] is equal to the
     * product of all the elements of nums except nums[i].
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int prefix = 1;
        int postfix = 1;
        int [] result = new int [nums.length];

        for (int i = 0; i < nums.length; i++) {
            if ( i != 0)
                prefix *= nums[i - 1];

            result[i] = prefix;
        }

        for (int i = nums.length - 1; i >=0;  i--) {
            if ( i != nums.length - 1)
                postfix *= nums[i + 1];

            result[i] *= postfix;
        }

        return result;
    }
}
