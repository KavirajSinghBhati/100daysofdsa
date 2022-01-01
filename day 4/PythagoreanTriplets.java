package com.kaviraj;

import java.util.Arrays;

public class PythagoreanTriplets {
//    Pythagorean Triplets => a2 + b2 = c2 where a, b, c are in the array
//    two ways=> naive approach which takes O(n3) time,
//    other way is sorting approach which takes O(n2) time
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 6, 5};
        System.out.println(tripletsNaive(arr));
        int[] arr2 = {10, 4, 6, 12, 5};
        System.out.println(tripletsEfficient(arr2));
        System.out.println(tripletsEfficient(arr));
    }
    static boolean tripletsNaive(int[] arr) {
        //naive approach
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; j < arr.length; j++) {
                    int x = arr[i] * arr[i], y =  arr[j] * arr[j], z = arr[k] * arr[k];
                    if (x == y + z || y == x + z || z == x + y)
                        return true;
                }
            }
        }
        return false;
    }
    static boolean tripletsEfficient(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 2; i--) {
            int low = 0, high = i - 1;
            while (low < high) {
                if (arr[low] + arr[high] == arr[i])
                    return true;
                else if (arr[low] + arr[high] > arr[i])
                    high--;
                else
                    low++;
            }
        }
        return false;
    }
}
