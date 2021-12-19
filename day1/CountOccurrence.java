package com.kaviraj;

public class CountOccurrence {
    public static void main(String[] args) {
        int[] arr = {12, 16, 22, 23, 56, 78, 78, 78, 78, 93, 93};
        int count = countOcc(arr, arr.length, 93);
        System.out.println(count);
    }
    static int countOcc(int[] arr, int n, int x) {
        int firstIdx = iterativeFirstOccurrence(arr, n, x);
        if (firstIdx == -1)
            return 0;
        else
            return (iterativeLastOccurrence(arr, n, x) - firstIdx + 1);
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
                if (mid == 0 || arr[mid - 1] != arr[mid])  //confirms that mid is actually the first occurrence
                    return mid;
                else
                    high = mid - 1;
            }
        }
        return -1;
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
                if (mid == n - 1 || arr[mid + 1] != arr[mid])  //confirms that mid is actually the last occurrence
                    return mid;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }
}
