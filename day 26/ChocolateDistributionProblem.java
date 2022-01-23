package com.kaviraj;

import java.util.Arrays;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56}; //array of chocolate packets
        int m = 3; //No of children
        int[] arr2 = {3, 4, 1, 9, 56, 7, 9, 12};
        int m2 = 5;
        int minDifference1 = chocolateProblem(arr, m, arr.length);
        int minDifference2 = chocolateProblem(arr2, m2, arr2.length);
        System.out.println(minDifference1);
        System.out.println(minDifference2);
    }
    static int chocolateProblem(int[] arr, int m, int n) {
        if (m > n)
            return -1;
        Arrays.sort(arr);
        int res = arr[m - 1] - arr[0];
        for (int i = 1; (i + m - 1) < n; i++) {
            res = Math.min(arr[i + m - 1] - arr[i], res);
        }
        return res;
    }
}
