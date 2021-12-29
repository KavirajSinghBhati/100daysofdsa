package com.kaviraj;

public class InversionsInArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        int count = inversionNaive(arr);
        System.out.println(count);
        count = inversionEfficient(arr, 0, arr.length - 1);
        System.out.println(count);
    }
    static int inversionNaive(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j])
                    res++;
            }
        }
        return res;
    }
    static int inversionEfficient(int[] arr, int low, int high) {
        int res = 0;
        if (high > low) {
            int mid = low + (high - low) / 2;
            res += inversionEfficient(arr, low, mid);
            res += inversionEfficient(arr, mid+1, high);
            res += countAndMerge(arr, low, mid, high);
        }
        return res;
    }
    static int countAndMerge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] left = new int[n1], right = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[m + j + 1];
        }
        int i = 0, j = 0, k = l, res = 0;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                res = res + (n1 - i);
            }
        }
        while (i < n1)
            arr[k++] = left[i++];
        while (j < n2)
            arr[k++] = right[j++];
        return res;
    }
}
