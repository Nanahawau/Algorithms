package com.nana.arrays;

import java.util.Arrays;

public class NonConstructibleChange {

    public static void main(String[] args) {

    }

    /**
     * [5, 7, 1, 1, 2, 3, 22]
     * find the minimum amount of change that can be formed
     * @param coins
     * @return
     */
    public int nonConstructibleChange(int[] coins) {
        // Write your code here.
        int change = 0;
        Arrays.sort(coins);
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > (change + 1)) return (change + 1);

            change += coins[i];
        }
        return change == 0? -1 : change;
    }

}
