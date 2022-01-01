package com.kaviraj;

import java.util.Arrays;

public class CountTripletsWithGivenSum {
//    3 approaches
//    naive => O(n3)
//    sorting => O(n2)
    public static void main(String[] args) {
        int[] arr = {0, -1, 2, -3, 1};
        int sum = -2;
        System.out.println(tripletsNaive(arr, arr.length, sum));
        //System.out.println(tripletsEfficient(arr, arr.length, sum));
    }
    static int tripletsNaive(int[] arr, int n, int x) {
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; j < n; j++) {
                    if (arr[i] + arr[j] + arr[k] == x)
                        count++;
                }
            }
        }
        return count;
    }
    static int tripletsEfficient(int[] arr, int n, int x) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = n - 1; i >= 2; i--) {
            int low = 0, high = i - 1;
            while (low < high) {
                if (arr[low] + arr[high] + arr[i] == x)
                    count++;
                else if (arr[low] + arr[high] + arr[i] > x)
                    high--;
                else
                    low++;
            }
        }
        return count;
    }
}
