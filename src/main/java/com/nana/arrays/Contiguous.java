package com.nana.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Contiguous {
    
    public static void main(String[] args) {
        int [] nums = {0,1, 0};
        findMaxLength2(nums);
    }


    /**
     * find contiguous subarrays that meet this condition
     * The value at index i must be the maximum element in the contiguous subarrays,
     * and
     * These contiguous subarrays must either start from or end on index i.
     * [3, 4, 1, 6, 2]
     * so you pick an element 
     * if the next element is not your element, not counted, you have one. 
     * for 4, 3 4, 4 1
     * 6, 6 2, 6 1, 6 1 4, 6 1 4 3 
     * 2 
     */

    int[] findCountOfContiguousSubArrayOptimized(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        result[0] = 1;
        // For every index, check from the left for possible contiguous arrays
        stack.push(0);
        for(int i = 1; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) 
            stack.pop(); // pop the stack elements till arr[stack top] is greater than or equal to the current element
            // after the above step either stack is empty or stack top is the max element and hence contiguous sub-arrays having max element at i are only possible till the stack top
            if(stack.isEmpty()) 
            result[i] = i + 1;
            else 
            result[i] = i - stack.peek();
            stack.push(i);
        }
        stack.clear();
        // For every index, check from the right for possible contiguous arrays
        stack.push(arr.length - 1);
        for(int i = arr.length - 2; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) 
            stack.pop();
            // after the above step either stack is empty or stack top is the max element and hence contiguous sub-arrays having max element at i are only possible till the stack top
            if(stack.isEmpty()) result[i] += (arr.length - i - 1);
            else result[i] += (stack.peek() - i - 1);
            stack.push(i);
        }
        return result;
    }



    int[] countSubarrays(int[] arr) {
        // Write your code here
        
        if (arr == null || arr.length <= 0)
         return new int[0];
        
        int [] result = new int [arr.length];
        Arrays.fill(result, 1);
        
        for (int i = 0; i < arr.length; i++) {     
          result[i] += count(arr, i, 1);
          result[i] += count(arr, i, -1);
        }
        
        return result;
      }
    
      
      static int count(int [] a, int currentIndex, int step) {
        int count = 0;
        int currentValue = a[currentIndex];
        currentIndex += step;
        
        while (currentIndex >= 0 && currentIndex < a.length) {
          
          if (a[currentIndex] < currentValue) {
            count++;
          } else {
            break;
          }
          
           currentIndex += step;
        }
        return count; 
      }
    

    public static int findMaxLength(int[] nums) {
        int maxlen = 0;
        for (int start = 0; start < nums.length; start++) {
            int zeroes = 0, ones = 0;
            for (int end = start; end < nums.length; end++) {
                if (nums[end] == 0) {
                    zeroes++;
                } else {
                    ones++;
                }
                System.out.println(zeroes + "zero");
                System.out.println(ones + "one");
                if (zeroes == ones) {
                    System.out.println(end + "start");
                    System.out.println(start + "end");
                    maxlen = Math.max(maxlen, end - start + 1);
                    System.out.println(maxlen + "maxlen");
                }
            }
        }
        return maxlen;
    }




/**
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 * Example 1:
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * @param nums
 * @return
 */
    public static int findMaxLength2(int[] nums) {
    	HashMap<Integer, Integer> map = new HashMap<>();
    	int maxlen = 0, count = 0;
    	for(int i = 0;i < nums.length;i++) {
    		count += (nums[i] == 1)? 1:-1;
    		if(count == 0)
    			maxlen = Math.max(maxlen, i+1);    		
    		if(map.containsKey(count)) {
    			maxlen = Math.max(maxlen, i - map.get(count));
    		} else 
    			map.put(count, i);
    	}
    	return maxlen;
    }
}


// Kadane's Algorithm