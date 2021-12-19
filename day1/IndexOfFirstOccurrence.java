package com.kaviraj;

import java.util.Scanner;

public class IndexOfFirstOccurrence {
    public static void main(String[] args) {
        int[] arr = {1, 10, 10, 10, 20, 20, 20, 30, 40};
        //int idx = recursiveFirstOccurrence(arr, 0, arr.length - 1, 20);
        int idx = iterativeFirstOccurrence(arr, arr.length, 30);
        System.out.println(idx);
    }
    static int recursiveFirstOccurrence(int[] arr, int low, int high, int x) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (arr[mid] > x)
            return recursiveFirstOccurrence(arr, low, mid - 1, x);
        else if (arr[mid] < x)
            return recursiveFirstOccurrence(arr, mid + 1, high, x);
        else {
            if (mid == 0 || arr[mid - 1] != arr[mid])  //confirms that mid is actually the first occurrence
                return mid;
            return recursiveFirstOccurrence(arr, low, mid - 1, x);
        }
    }

    static int iterativeFirstOccurrence(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x)
                high = mid - 1;
            else if (arr[mid] < x)
                low = mid + 1;
            else {
                if (mid == 0 || arr[mid - 1] != arr[mid])   //confirms that mid is actually the first occurrence
                    return mid;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}
