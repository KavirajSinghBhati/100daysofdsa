package com.kaviraj;

public class IntersectionOfTwoSorted {
    public static void main(String[] args) {
        int[] arr1 = {3, 5, 10, 10, 10, 15, 15, 20};
        int[] arr2 = {5, 10, 10, 15, 30};
        intersection(arr1, arr2);
        System.out.println();
        intersectionEfficient(arr1, arr2);
    }
    //Naive approach
    static void intersection(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (i > 0 && arr1[i] == arr1[i - 1]) //duplicate condition for arr1
                continue;
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    System.out.print(arr1[i] + " ");
                    break;   //breaking because we don't want duplicate elements in arr2 to be printed
                }
            }
        }
    }
    //Efficient Approach: Uses Merge Function
    static void intersectionEfficient(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }
            if (arr1[i] < arr2[j])
                i++;
            else if (arr1[i] > arr2[j])
                j++;
            else {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }
    }
}
