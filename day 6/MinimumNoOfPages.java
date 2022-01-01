package com.kaviraj;

public class MinimumNoOfPages {
    public static void main(String[] args) {
        int[] arr = {10, 5, 30, 1, 2, 5, 10, 10};
        int k = 3;
        System.out.println(minPages(arr, arr.length, k));
    }
    static int sum(int[] arr, int b, int e) {
        int sum = 0;
        for (int i = b; i <= e; i++) {
            sum += arr[i];
        }
        return sum;
    }
    static int minPages(int[] arr, int n, int k) {
//        exponential time complexity
        if (k == 1)
            return sum(arr, 0, n - 1);
        if (n == 1)
            return arr[0];
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.min(res, Math.max(minPages(arr, i, k - 1), sum(arr, i, n - 1)));
        }
        return res;
    }
}
