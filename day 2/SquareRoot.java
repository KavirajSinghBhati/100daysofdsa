package com.kaviraj;

public class SquareRoot {
//    find square root of a number in O(log x) time, where x
//    is the number

    public static void main(String[] args) {
        System.out.println(naiveSquareRoot(14));
        System.out.println(squareRoot(17));
    }
    static int naiveSquareRoot(int x) {
//        returns floor of the square root
//        time complexity: O(sqrt(x))
        int i = 1;
        while (i * i <= x) {
            i++;
        }
        return (i - 1);
    }
    static int squareRoot(int x) {
//        efficient approach: use Binary Search
        int low = 0, high = x, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int msq = mid * mid;
            if (x == msq)
                return mid;
            else if (msq > x)   //go in left sub half
                high = mid - 1;
            else {              //any smaller value can be square root, so store it.
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}
