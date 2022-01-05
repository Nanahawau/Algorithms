package com.nana.arrays;

import java.util.Arrays;

/**
 * Rotate Array
 */

public class RotateArray {

    // reverse an array
    // [5, 6, 7, 1, 2, 3, 4]
    // rotate an array by 3
    // find the number of rotation

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        // 0, 1, 2, 3, 4, 5, 6
        int[] array = { 3, 4, 5, 6, 7, 1, 2 };

        System.out.println(Arrays.toString(rotateArray(arr, 3)));
        System.out.println(noOfRotation(array));
        System.out.println(countRotations(array, 0, array.length - 1));
    }

    static int[] rotateArray(int[] array, int k) {
        k = k % array.length;
        System.out.println(k);
        reverse(array, 0, array.length - 1);
        reverse(array, 0, k - 1);
        reverse(array, k, array.length - 1);

        return array;
    }

    static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Linear search approach
     */
    static int noOfRotation(int[] array) {
        // the index with the minvalue is the number of rotation
        // how far the first item has moved

        int minIndex = 0;
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * Binary search method
     */
    static int countRotations(int arr[], int low,
            int high) {
        // This condition is needed to handle
        // the case when array is not rotated
        // at all
        if (high < low)
            return 0;

        // If there is only one element left
        if (high == low)
            return low;

        // Find mid
        // /*(low + high)/2;*/
        int mid = low + (high - low) / 2;

        // Check if element (mid+1) is minimum
        // element. Consider the cases like
        // {3, 4, 5, 1, 2}
        if (mid < high && arr[mid + 1] < arr[mid])
            return (mid + 1);

        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
            return mid;

        // Decide whether we need to go to left
        // half or right half
        if (arr[high] > arr[mid])
            return countRotations(arr, low, mid - 1);

        return countRotations(arr, mid + 1, high);
    }

}
