package com.kaviraj;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30, 40, 50};
        int[] arr2 = {5, 15, 25, 35, 45};

        System.out.println(median(arr1, arr2));
    }
    static double median(int[] arr1, int[] arr2) {
//        base condition is arr1.length <= arr2.length
        if (arr2.length < arr1.length)
            return median(arr2, arr1);
        int n1 = arr1.length;
        int n2 = arr2.length;
        int low = 0, high = n1;
//      binary search would be applied on the smallest array
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int right1 = cut1 == n1 ? Integer.MAX_VALUE : arr1[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : arr2[cut2];

            if (left1 <= right2 && left2 <= right1) {
                if ((n1 + n2) % 2 == 0)
                    return (double) (Math.max(left1, left2) + Math.min(right1, right2)) / 2;
                else
                    return (double) Math.max(left1, left2);
            }
            else if (left1 > right2) {
                high = cut1 - 1;
            }
            else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
}
