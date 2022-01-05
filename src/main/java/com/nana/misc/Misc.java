package com.nana.misc;

public class Misc {
    
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }


    static int factorial (int n) {
         if (n == 1)
            return 1; 

            return n * factorial(n - 1);
    }


    // o (log n )
    // o (1)
    static int binarySearch (int [] arr , int target) {

        int left = arr[0];
        int right = arr.length - 1; 

        while (left < right) {
            int mid = (int) Math.floor((left = right) / 2);

            if (target < arr[mid]) {
                right = mid - 1; 
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // o log n 
    // o log n 
    static int binarySH (int [] arr, int target) {
        return recursiveBinarySearch(arr, arr[0], arr.length - 1);
    }

    static int recursiveBinarySearch (int [] arr , int left, int right) {

        if (left > right)
        return -1;

        int mid = (int) Math.floor((left+right) / 2);

        if (left < arr[mid]) {
            return recursiveBinarySearch(arr, left, mid - 1);
        } else if (left > arr[mid]) {
            return recursiveBinarySearch(arr, mid + 1, right);
        } else {
            return mid;
        }
    }


    /**
     * Coin Change making problem
     * Top down approach 
     * Bottom up approach
     */


    //  static int coinChange(int [] arr ) {

    //  }



// Fn = Fn-1 + Fn - 2
    static int fibR(int n) {
        return n;
    }


    static int fibI(int n) {
        if(n == 1 || n == 2)
        return 1;

        return fibI(n - 1) + fibI(n - 2);
    }
}
