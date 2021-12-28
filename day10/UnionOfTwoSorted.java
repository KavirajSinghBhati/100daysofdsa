package com.kaviraj;

import java.util.Arrays;

public class UnionOfTwoSorted {
    public static void main(String[] args) {
        int[] arr1 = {3, 5, 8};
        int[] arr2 = {2, 8, 9, 10, 15};
        unionNaive(arr1, arr2);
        System.out.println();
        unionEfficient(arr1, arr2);
    }

    static void unionNaive(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int[] c = new int[m + n];
        for (int i = 0; i < m; i++) {
            c[i] = arr1[i];
        }
        for (int i = 0; i < n; i++) {
            c[m + i] = arr2[i];
        }
        Arrays.sort(c);
        for (int i = 0; i < (m + n); i++) {
            if (i == 0 || c[i] != c[i - 1])
                System.out.print(c[i] + " ");
        }
    }
    static void unionEfficient(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }
            if (j > 0 && arr2[j] == arr2[j - 1]) {
                j++;
                continue;
            }
            if (arr1[i] < arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++;
            }
            else if (arr1[i] > arr2[j]) {
                System.out.print(arr2[j] + " ");
                j++;
            }
            else {
                System.out.print(arr1[i] + " ");
                i++; j++;
            }
        }
        while (i < arr1.length) {
            if (i > 0 && arr1[i] != arr1[i - 1]) {
                System.out.print(arr1[i] + " ");
                i++;
            }
        }
        while (j < arr2.length) {
            if (j > 0 && arr2[j] != arr2[j - 1]) {
                System.out.print(arr2[j] + " ");
                j++;
            }
        }
    }
}
