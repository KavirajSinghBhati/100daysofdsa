package com.kaviraj;

public class IndexOfLastOccurrence {
    public static void main(String[] args) {
        int[] arr = {1, 10, 10, 10, 20, 20, 20, 30, 40};
        //int idx = recursiveLastOccurrence(arr, 0, arr.length - 1, 10);
        int idx = iterativeLastOccurrence(arr, arr.length, 20);
        System.out.println(idx);
    }
    static int recursiveLastOccurrence(int[] arr, int low, int high, int x) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (arr[mid] > x)
            return recursiveLastOccurrence(arr, low, mid - 1, x);
        else if (arr[mid] < x)
            return recursiveLastOccurrence(arr, mid + 1, high, x);
        else {
            if (mid == arr.length - 1 || arr[mid + 1] != arr[mid])  //confirms that mid is actually the last occurrence
                return mid;
            return recursiveLastOccurrence(arr, mid + 1, high, x);
        }
    }

    static int iterativeLastOccurrence(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x)
                high = mid - 1;
            else if (arr[mid] < x)
                low = mid + 1;
            else {
                if (mid == n - 1 || arr[mid + 1] != arr[mid])   //confirms that mid is actually the last occurrence
                    return mid;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }
}
