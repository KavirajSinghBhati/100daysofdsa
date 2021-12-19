package com.kaviraj;

public class OccurrenceOfOnes {
    public static void main(String[] args) {
        //Problem Stmt: Count the occurrences of 1's in a sorted binary array.
        int[] arr = {0, 0, 0, 1, 1, 1, 1};
        int count = onesCount(arr, arr.length);
        System.out.println(count);
    }
    static int onesCount(int[] arr, int n) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == 0)
                low = mid + 1;
            else {
                if (mid == 0 || arr[mid - 1] == 0)
                    return n - mid;
                else high = mid - 1;
            }
        }
        return 0;
    }
}
