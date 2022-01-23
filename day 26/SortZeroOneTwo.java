package com.SortThreeTypes;

import java.util.Arrays;

public class SortZeroOneTwo {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 2};
        //sortNaive(arr, arr.length);  // [0, 0, 1, 1, 2, 2]

//        Efficient approach : Dutch National Flag Algorithm
        sortEfficient(arr, arr.length);  // [0, 0, 1, 1, 2, 2]
        System.out.println(Arrays.toString(arr));
    }

    static void sortNaive(int[] arr, int n) {
        int[] temp = new int[n];
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] == 0)
                temp[i++] = arr[j];
        }
        for (int j = 0; j < n; j++) {
            if (arr[j] == 1)
                temp[i++] = arr[j];
        }
        for (int j = 0; j < n; j++) {
            if (arr[j] == 2)
                temp[i++] = arr[j];
        }
        for (int j = 0; j < n; j++) {
            arr[j] = temp[j];
        }
    }

    static void sortEfficient(int[] arr, int n) {
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low++] = arr[mid];
                arr[mid++] = temp;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high--] = temp;
            }
        }
    }
}


/* There are multiple approaches to solve this problem.
*  1. Sort the array (n log n)
*  2. Two pass algorithm (in first pass, we count no of 0s, 1s and 2s. In second pass we overwrite the array using the counts) => (O(n) time and two traversals)
*  3. Use sortNaive function above (O(n) time and O(1) space and 4 traversals)
*  4. Use Dutch national flag algo. (O(n) time and single traversal)
*  */