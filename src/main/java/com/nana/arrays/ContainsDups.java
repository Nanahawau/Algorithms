package com.nana.arrays;

import java.util.HashSet;

public class ContainsDups {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    /**
     * Given an integer array nums, return true if any value appears at least twice in the array,
     * and return false if every element is distinct.
     */
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                continue;
            }
            return true;
        }
        return false;
    }
}
