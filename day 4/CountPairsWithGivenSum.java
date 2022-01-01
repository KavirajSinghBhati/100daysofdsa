package com.kaviraj;

import java.util.HashMap;

public class CountPairsWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int x = 6;
        System.out.println(pairsNaive(arr, x));
        System.out.println(pairsEfficient(arr, x));
    }
    static int pairsNaive(int[] arr, int x) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == x)
                    count++;
            }
        }
        return count;
    }
    static int pairsEfficient(int[] arr, int x) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (m.containsKey(x - arr[i]))
                count += m.get(x - arr[i]);
            if (m.containsKey(arr[i]))
                m.put(arr[i], m.get(arr[i]) + 1);
            else
                m.put(arr[i], 1);
        }
        return count;
    }
}
