

package sort;
import java.util.Arrays;

public class merge_sort {
	//merge sub arrays 
	public static void merge(int arr[], int l[], int r[], int left, int right) {
		 
	    int i = 0, j = 0, k = 0;
	    while (i < left && j < right) {
	        if (l[i] <= r[j]) {
	            arr[k] = l[i];
	            i++;
	            k++;}
	        else {
	            arr[k] = r[j];
	            j++;
				k++;}
	    }
	    while (i < left) {
	        arr[k] = l[i];
	        i++;
            k++;}
	    while (j < right) {
	        arr[k] = r[j];
	        j++;
            k++;}
	}
	
	//Sort function using merge()
	public static void mergeSort(int array[], int len) {
	    if (len < 2) {
	        return;}
	    int mid = len / 2;
	    int[] left = new int[mid];
	    int[] right = new int[len - mid];
	 
	    for (int i = 0; i < mid; i++) {
	        left[i] = array[i];}
			
	    for (int i = mid; i < len; i++) {
	        right[i - mid] = array[i];}
	    
		mergeSort(left, mid);
	    mergeSort(right, len - mid);
	    merge(array, left, right, mid, len - mid);
	}	

	//Driver method
	public static void main(String args[]) {
	    int[] nums = {5,1,1,2,0,0};
	    int n= nums.length;
	    System.out.println("Given array;");
	    System.out.println(Arrays.toString(nums));
	    mergeSort(nums, n);
	    System.out.println("\nSorted number using merge sort:");
	    System.out.println(Arrays.toString(nums));
		
		
	}
}

