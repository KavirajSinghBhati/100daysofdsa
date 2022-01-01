package com.kaviraj;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pl. enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Entering the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the element to search: ");
        int x = sc.nextInt();
        int idx = iterativeBinarySearch(arr, n, x);
        System.out.println(idx);
    }
    static int recursiveBinarySearch(int[] arr, int low, int high, int x) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == x)
            return mid;
        else if (arr[mid] > x)
            return recursiveBinarySearch(arr, low, mid - 1, x);
        else
            return recursiveBinarySearch(arr, mid + 1, high, x);
    }

    static int iterativeBinarySearch(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
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
