package com.nana.qands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueRemovals {
    public static void main(String[] args) {
        
    }

   

    // int[] findPositions(int[] arr, int x) {
    //   // Write your code here
    //   int[] result = new int[x];
    //   Queue<int[]> queue = new LinkedList();
    //   for(int i=0;i<arr.length;i++){
    //     queue.offer(new int[]{arr[i],i+1});
    //   }   

    //   System.out.println(queue);

    //   int i=0;
    //   while(i<x && !queue.isEmpty()){
    //         int size = x;
    //         PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->b[0] == a[0]? a[1]-b[1] : b[0]-a[0]);
    //         Queue<int[]> temp = new LinkedList();
    //         while(size>0 && !queue.isEmpty()){
    //           int[] ele = queue.poll();
    //           pq.offer(ele);
    //           temp.offer(ele); //This  is needed to maintain original order of elements in the queue.
    //           size--;
    //         }
    //         int[] max = pq.poll();
    //         result[i++]= max[1];
    //         while(!temp.isEmpty()){
    //           int[] ele = temp.poll();
    //           if(ele[0]==max[0] && ele[1]==max[1]){ // or we can do if(max==ele) or Arrays.equals(max, ele)
    //             continue;
    //           }
    //           if(ele[0]!=0){
    //             ele[0]--;
    //           }
    //           queue.offer(ele);
    //         }
    //   }
    //   return result;
    // }

    // // [1, 2, 2, 3, 4, 5]
    // // x = 5

    // int[] findPositions(int[] arr, int x) {
    //     // Write your code here

    //     int[] outputArray = new int[x];
    //     HashMap<Integer, Integer> poppedElements = new HashMap<>();

    //     // iterate for the first 3 steps
    //     for (int i = 0; i < x; i++) {
            
    //     }

    //     return poppedElements.values().toArray();
    //   }

    //   // step 1 
    //   // remove x elements from the front of the queue 

    //   static List<Integer> pop (HashMap<Integer, Integer> poppedElements, int arr [], int x) {
    //     int maxIndex = 0;
    //     int maxValue = 0;
       
    //     int loopLimit = arr.length < x?  arr.length : x;
    //     List<Integer> poppedArray = new ArrayList<>();

    //     for (int i = 0; i < loopLimit; i++) {
    //       poppedArray.add(arr[i]);
    //     } 

    //     for (int i = 0; i < poppedArray.size(); i++) {
    //       if (arr[i] > maxValue)
    //         maxValue = arr[i];
    //         maxIndex = i;
    //     }

    //     poppedArray.remove(maxIndex);
    //     poppedElements.put(maxValue, maxIndex);

    //   for (Integer item: poppedArray) {
    //       if (item >= 1)
    //           item--;
    //   }
        
    //     return poppedArray;
    //   }
}
