package com.kaviraj;

public class TwoSum {
//    given => sorted array and a sum
//    return true if a pair with this sum exists, else return false
//    naive approach => run two loops [ O(n2) ]
//    efficient approach => Two Pointer Approach [ O(n) ]
    public static void main(String[] args) {
        int[] arr = {2, 4, 8, 9, 11, 12, 20, 30};
        int sum = 23;
        System.out.println(twoSum(arr, sum));
    }
    static boolean twoSum(int[] arr, int sum) {
        int left = 0, right = arr.length - 1;
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
