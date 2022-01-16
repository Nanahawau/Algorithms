package com.nana.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int A[] = { 1, 4, 45, 6, 10, 8 };
        int sum = 22;
        System.out.println(threeNumberSum(A, sum));
    }

    /**
     * Algoexpert did o(n2), weird
     * Going over the solution
     * @param array
     * @param targetSum
     * @return
     */
    static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<Integer[]>();

        for (int i =0; i < array.length - 2; i++) {
            int start = i + 1;
            int end = array.length - 1;
            while (start < end) {
                int sum = (array[start] + array[end] + array[i]);
                if (sum == targetSum) {
                    Integer[] r = {array[i], array[start], array[end]};
                    result.add(r);
                    start++;
                    end--;
                } else if (sum < targetSum) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}
