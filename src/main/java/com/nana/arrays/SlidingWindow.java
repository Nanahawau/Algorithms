package com.nana.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingWindow {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(averageSum(arr, 3)));
    }

    /**
     * Brute force technique, sliding window
     */

    static int[] averageSum(int[] arr, int k) {

        List<Integer> averages = new ArrayList<Integer>();
        for (int i = 0; i <= arr.length - k; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += arr[i + j];
            }
            averages.add((sum / k));
        }
        return toPrimitiveArray(averages);
    }

    /**
     * 
     * @param arr
     * @return
     */
    static int[] optimizedAverageSum(int[] arr, int k) {
        int windowSum = 0;
        List<Integer> averages = new ArrayList<Integer>();
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            if (windowEnd >= k - 1) {
                // add average of windowSum to averages
                averages.add((windowSum / k));
                // move window start to spot one
                windowSum -= arr[windowStart];
                // substract integer at windowStart from windowSum
                windowStart++;
            }
        }
        return toPrimitiveArray(averages);
    }


    /**
     * 
     * @param arr
     * @return
     */
    static int[] toPrimitiveArray(List<Integer> arr) {

        int[] intArray = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            intArray[i] = arr.get(i);
        }
        return intArray;
    }



}
