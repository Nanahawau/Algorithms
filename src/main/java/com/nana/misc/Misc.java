package com.nana.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Misc {
    
    public static void main(String[] args) {

        System.out.println(factorial(5));
        String s = "hello";
        System.out.println(s.contentEquals("e"));
        StringBuilder sa = new StringBuilder("HelloMadam");
        System.out.println(sa.subSequence(0, 2));

        // right pad
        String rightPad = String.format("%" + (-10) + "s", s).replace(' ', '-');
        String leftPad = String.format("%" + 10 +"s" , s).replace(' ', 'a');
        System.out.println(rightPad);
        System.out.println(leftPad);

        List<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(3);

        Collections.sort(c, Collections.<Integer>reverseOrder());
        System.out.println(c);


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




// Fn = Fn-1 + Fn - 2
    static int fibR(int n) {
        return n;
    }


    static int fibI(int n) {
        if(n == 1 || n == 2)
        return 1;

        return fibI(n - 1) + fibI(n - 2);
    }

    /**
     * Total occurences of K in a sorted array
     * [1, 1, 1, 3, 5, 6]
     * @param arr
     * @return
     */
//    static int topOccurencesOfK (int [] arr) {
//        // binary search
//
//    }
}
