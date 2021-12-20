package com.kaviraj;

public class PeakElement {
//    peak element => it's neighbours are less than it.
//    given array is unsorted
//    naive approach takes O(n) time
//    efficient approach: use binary search (but how)

    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 20, 12};
        System.out.println(naiveApproach(arr));
        System.out.println(efficientApproach(arr));
    }
    static int naiveApproach(int[] arr) {
        if (arr.length == 1)
            return arr[0];
        if (arr[0] > arr[1])
            return arr[0];
        if (arr[arr.length - 1] > arr[arr.length - 2])
            return arr[arr.length - 1];
        for (int i = 1; i < arr.length - 1; i++) {
            if ((arr[i] >= arr[i - 1]) && (arr[i] >= arr[i + 1]))
                    return arr[i];
        }
        return -1;
    }
    static int efficientApproach(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == arr.length - 1 ||arr[mid] >= arr[mid + 1]))
                return arr[mid];
            if (mid > 0 && arr[mid - 1] >= arr[mid])  //peak on left side
                high = mid - 1;
            else
                low = mid + 1;      //peak on right side
        }
        return -1;
    }
}
