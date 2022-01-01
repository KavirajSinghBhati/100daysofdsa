package com.kaviraj;

public class MinPagesBinarySearch {
    public static void main(String[] args) {
        int[] arr = {10, 5, 30, 1, 2, 5, 10, 10};
        int k = 3;
        System.out.println(minPages(arr, arr.length, k));
    }

    static int minPages(int[] arr, int n, int k) {
        int sum = 0, mx = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            mx = Math.max(mx, arr[i]);
        }
        int low = mx, high = sum, res = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isFeasible(arr, n, k, mid)) {
                res = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return res;
    }

    static boolean isFeasible(int[] arr, int n, int k, int ans) {
        int req = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] > ans) {
                req++;
                sum = arr[i];
            }
            else sum += arr[i];
        }
        return (req <= k);
    }
}
