package com.nana.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class PairSums {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 3, 3};
        // int [] ar = {1, 2, 3, 4, 3};
        System.out.println(naivePairSums(arr, 6));
        System.out.println(pairSumOP(arr, 6));
    }

    /**
     * 0(n2) solution
     * @param arr
     * @param k
     * @return
     */
    static int naivePairSums(int [] arr , int k) {

        int countPairSums = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k)
                countPairSums++;
            }
        }
        return countPairSums;
    }

    /**
     * Will the numbers be unique?
     * Will there be repeated numbers?
     * Pair sum count
     * @param arr
     * @param k
     * @return
     */
    static int pairSumOP (int [] arr, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (!frequencyMap.containsKey(arr[i])) {
                frequencyMap.put(arr[i], 1);
            } else {
                frequencyMap.put(arr[i], frequencyMap.get(arr[i])+ 1);
            }
        }

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            if (frequencyMap.get(k - arr[i]) != null) {
                count += frequencyMap.get(k-arr[i]);
            }

            // why this?

            if (k - arr[i] == arr[i]) {
                count--;
            }
        }
        return count/2;
    }


    public int[] twoSum(int[] numbers, int target)
    {
        Arrays.sort(numbers); // have to do this for unsorted arrays
        int start = 0;
        int end = numbers.length - 1;
        int[] result = new int[] {0, 0};
        while (start < end)
        {
            if (numbers[start] + numbers[end] == target)
            {
                result[0] = start + 1;
                result[1] = end + 1;
                break;
            }
            else if (numbers[start] + numbers[end] < target)
            {
                start++;
            }
            else
            {
                end--;
            }
        }
        return result;
    }
}
