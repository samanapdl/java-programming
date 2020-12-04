
package sort;

import java.util.Arrays;

public class quicksort {
	public static int partition(int arr[], int left, int right) 
    { 
        int p = arr[right];  
        int index = (left-1); 
        for (int j=left; j<right; j++) 
        {        
            if (arr[j] < p){ 
                index++; 
                swap(arr, index , j); }
        } 
        swap(arr, index+1 , right);
        return index+1; 
    } 
  
	public static void swap(int[] a, int i,int j) {
		int tem = a[i];
		a[i]=a[j];
		a[j]=tem;
	}
   
    public static void QuickSort(int arr[], int left, int right) 
    { 
        if (left < right) 
        { 
            int part = partition(arr, left, right); 
            QuickSort(arr, left, part-1); 
            QuickSort(arr, part+1, right); 
        } 
    } 
    
	
	//Driver method
	public static void main(String args[]) {
	    
	    int[] nums = {5,1,1,2,0,0};
	    int n= nums.length;
	    System.out.println("Given array;");
	    System.out.println(Arrays.toString(nums));
	    QuickSort(nums, 0, n-1);
	    System.out.println("\nSorted number using quick sort:");
	    System.out.println(Arrays.toString(nums));
	}}