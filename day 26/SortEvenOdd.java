package com.SortTwoTypes;

import java.util.Arrays;

public class SortEvenOdd {
    public static void main(String[] args) {
        int[] arr = {15, 14, 13, 12};
        //sortNaive(arr, arr.length);  [14, 12, 15, 13]
        sortEfficient(arr, arr.length); // [12, 14, 13, 15]
        System.out.println(Arrays.toString(arr));
    }

    static void sortNaive(int[] arr, int n) {
        int[] temp = new int[n];
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] % 2 == 0)
                temp[i++] = arr[j];
        }
        for (int j = 0; j < n; j++) {
            if (arr[j] % 2 != 0)
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
            } while (arr[i] % 2 == 0);
            do {
                j--;
            } while (arr[j] % 2 != 0);
            if (i >= j)
                return;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
