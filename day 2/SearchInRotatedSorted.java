package com.kaviraj;

public class SearchInRotatedSorted {
//    naive approach: use Linear Search
//    efficient approach: use Binary Search
//    find the array part (left or right) that is sorted
//    Time Complexity : O(log n)
    public static void main(String[] args) {
        int[] arr = {100, 200, 400, 1000, 10, 20};
        System.out.println(searchInRotatedSortedArray(arr, 10));
    }
    static int searchInRotatedSortedArray(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x)
                return mid;
            else if (arr[low] < arr[mid]) {     //left sub-half sorted
                if (x >= arr[low] && x < arr[mid])
                    high = mid - 1;      //search in left sub-half
                else
                    low = mid + 1;  //search in right sub-half
            }
            else {                              //right sub-half sorted
                if (x <= arr[high] && x > arr[mid])
                    low = mid + 1;      //search in right sub-half
                else
                    high = mid - 1;     //search in left sub-half
            }
        }
        return -1;
    }
}
