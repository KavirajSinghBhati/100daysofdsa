package com.kaviraj;

import java.util.Arrays;

public class NaivePartition {
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 12, 10, 7};
        int p = 5;
        int pivotIndex = naivePartition(arr, 0, arr.length - 1, p);
        System.out.println(pivotIndex);
        System.out.println(Arrays.toString(arr));
    }
    static int naivePartition(int[] arr, int low, int high, int p) {
        int[] temp = new int[high - low + 1];
        int idx = 0;
        for (int i = low; i <= high; i++) {
            if (arr[i] <arr[p])
                temp[idx++] = arr[i];
        }
        for (int i = low; i <= high; i++) {
            if (arr[i] == arr[p])
                temp[idx++] = arr[i];
        }
        int res = idx - 1 + low;
        for (int i = low; i <= high; i++) {
            if (arr[i]  > arr[p])
                temp[idx++] = arr[i];
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
        return res;
    }
}
