package com.SortTwoTypes;

import java.util.Arrays;

public class SortPositiveNegative {
    public static void main(String[] args) {
        int[] arr = {15, -3, -2, 18};
        //sortNaive(arr, arr.length); [-3, -2, 15, 18]
        sortEfficient(arr, arr.length);  // [-2, -3, 15, 18]
        System.out.println(Arrays.toString(arr));
    }

    static void sortNaive(int[] arr, int n) {
        int[] temp = new int[n];
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] < 0)
                temp[i++] = arr[j];
        }
        for (int j = 0; j < n; j++) {
            if (arr[j] >= 0)
                temp[i++] = arr[j];
        }
        for (int j = 0; j < n; j++)
            arr[j] = temp[j];
    }

    static void sortEfficient(int[] arr, int n) {
        int i = -1, j = n;
        while (true) {
            do {
                i++;
            } while (arr[i] < 0);
            do {
                j--;
            } while (arr[j] >= 0);
            if (i >= j)
                return;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
