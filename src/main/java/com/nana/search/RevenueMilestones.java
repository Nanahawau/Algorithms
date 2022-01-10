package com.nana.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class RevenueMilestones {
    public static void main(String[] args) {
        int [] revenues = {10,20,30,40,50,60,70,80,90,100};
        int [] milestones = {100, 200, 500};
        getMilestoneDays(revenues, milestones);
    }


    public static int[] getMilestoneDays(int[] revenues, int[] milestones) {
        // Write your code here
        
       int sum = 0; 
       int [] result = new int[milestones.length];
       TreeMap<Integer, Integer> map = new TreeMap<Integer,Integer>();
       Arrays.fill(result, -1);

        for (int i = 0; i < revenues.length; i++) {
            sum += revenues[i];
            map.put(sum, i+1);
        }
        for (int i = 0; i < milestones.length; i++) {
            result[i] = map.ceilingEntry(milestones[i]).getValue();
        }
        return result;
      }
}
