package com.kaviraj;


public class UnboundedBinarySearch {
//    Given an infinite sized sorted array and an element, search it.
//    array size can be in millions.
//    naive approach takes O(pos) time when
//    pos is position of ele in array
//    efficient approach => Unbounded Binary Search [ O(log pos) ]

    public static void main(String[] args) {
//      example array
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 100, 101, 102, 103};
        System.out.println(naiveApproach(arr, 81));
        System.out.println(efficientApproach(arr, 86));
    }
    static int naiveApproach(int[] arr, int x) {
        int i = 0;
        while (true) {
            if (arr[i] == x)
                return i;
            if (arr[i] > x)
                return -1;
            i++;
        }
    }

    static int efficientApproach(int[] arr, int x) {
        if (arr[0] == x)
            return 0;
        int i = 1;
        while (arr[i] < x) {
            i = i * 2;
        }
//        here arr[i] >= x
        return binarySearch(arr, x, i/2 + 1, i - 1);
    }

    static int binarySearch(int[] arr, int x, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] > x)
                high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
