import java.util.*;
import java.lang.*;
import java.io.*;

public class KthSmallestNaive
{
    public static void main (String[] args) 
    {
        int arr[] = new int[]{10,5,30,12};
        
        int n = arr.length;int k=2;
        
	    System.out.print(kthSmallest(arr,n,k));
        
    }
    
    static int kthSmallest(int arr[], int n, int k)
    {   
        Arrays.sort(arr);
        return arr[k-1];
    }
}
