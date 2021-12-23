package com.kaviraj;

import java.util.Arrays;

public class RepeatingElement {
//    repeatingElementSol1 => O(n2) time and O(1) space
//    repeatingElementSol2 => O(n log n) time and O(1) space
//    repeatingElementSol3 => O(n) time and O(n) space
//    repeatingElementSol4 => O(n) time and O(1) space

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 3, 2, 2};
        System.out.println(repeatingElementSol1(arr, arr.length));
        System.out.println(repeatingElementSol2(arr, arr.length));
        System.out.println(repeatingElementSol3(arr, arr.length));
        System.out.println(repeatingElementSol4(arr, arr.length));
    }
    static int repeatingElementSol1(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j])
                    return arr[i];
            }
        }
        return -1;
    }
    static int repeatingElementSol2(int[] arr, int n) {
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1])
                return arr[i];
        }
        return -1;
    }

    static int repeatingElementSol3(int[] arr, int n) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[arr[i]])
                return arr[i];
            visited[arr[i]] = true;
        }
        return -1;
    }

    static int repeatingElementSol4(int[] arr, int n) {
        int slow = arr[0] + 1, fast = arr[0] + 1;
        do {
            slow = arr[slow] + 1;
            fast = arr[arr[fast] + 1] + 1;
        } while(slow!= fast);

        slow = arr[0] + 1;

        while(slow != fast) {
            slow = arr[slow] + 1;
            fast = arr[fast] + 1;
        }
        return slow - 1;
    }
 }



// When we have min element in array as 1 => use this approach
/*
*
* int slow = arr[0], fast = arr[0];
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while(slow!= fast);

        slow = arr[0];

        while(slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
* */