package com.nana.arrays;

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
}
