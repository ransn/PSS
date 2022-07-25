package com.snr.pss.algo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FindNthFibinocciSeries {
    public static void main(String[] args){
        // n=6; fibinocci numbers are [0,1,1,2,3,5] answer is 5
        // f(n) = f(n-1) + f(n-2)
        int n = 6;
        // Recursive approach - Time O(n^2) | Space O(n)
        System.out.println("Recursive approach: "+ findFibSeries(n));

        // Recursive + use hashmap - Time O(n) | Space O(n)
        Map<Integer, Integer> valueMap = new HashMap<>();
        valueMap.put(0, 0);
        valueMap.put(1, 0);
        valueMap.put(2, 1);
        System.out.println("Recursive + use hashmap: "+ findFibSeriesApproach2(n, valueMap));

        // Iterative approach - Time O(n) | Space O(1)
        System.out.println("Iterative approach: "+findFibSeriesApproach3(n));
    }

    private static int findFibSeriesApproach3(int n) {
        int[] lastTwoValues = new int[] {0, 1};
        int counter = 3;
        while (counter <= n){
            int nextValue = lastTwoValues[0] + lastTwoValues[1];
            lastTwoValues[0] = lastTwoValues[1];
            lastTwoValues[1] = nextValue;
            counter ++;
        }
        return n == 0 ? lastTwoValues[0] : lastTwoValues[1];
    }

    private static int findFibSeriesApproach2(int n, Map<Integer, Integer> valueMap) {
        if( n == 0 || n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        if (!valueMap.containsKey(n)) {
            valueMap.put(n, findFibSeriesApproach2(n - 1, valueMap) + findFibSeriesApproach2(n - 2, valueMap));
        }
        return valueMap.get(n);
    }

    private static int findFibSeries(int n) {
        if( n == 0 || n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        return findFibSeries(n-1) + findFibSeries(n-2);
    }
}
