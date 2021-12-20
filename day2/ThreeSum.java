package com.kaviraj;

public class ThreeSum {
    //    given => sorted array and a sum
    //    return true if a triplet with this sum exists, else return false
    //    naive approach => run three loops [ O(n3) ]
    //    efficient approach => Two Pointer Approach [ O(n) ] for every element
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 8, 9, 20, 40};
        int sum = 32;
        System.out.println(threeSum(arr, sum));
    }
    static boolean threeSum(int[] arr, int sum) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            if (twoSum(arr, i + 1, n - 1, sum - arr[i]))
                return true;
        }
        return false;
    }
    static boolean twoSum(int[] arr, int left, int right, int sum) {
        while (left < right) {
            if (arr[left] + arr[right] == sum)
                return true;
            else if (arr[left] + arr[right] > sum)
                right--;
            else
                left++;
        }
        return false;
    }
}
