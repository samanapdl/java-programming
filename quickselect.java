/** SONY THAPA 
 * 50253072
 * CSC 428
 * 10/25/2020 **/


package array;

public class quickselect {
	
	public static int findKthLargest(int[] nums, int k) {
		int low=0;
		int high = nums.length -1;
		k = nums.length - k;
		while(low<high) {
			int PartitionIndex= partition(nums, low, high);
			if(PartitionIndex<k) // checking right subarray 
				low= PartitionIndex+1;
			else if(PartitionIndex>k) // checking left subarray
				high = PartitionIndex -1;
			else
				break;
		}
		return nums[k];
	}
	
	public static int partition(int [] a, int lo, int hi) {
		int p=a[hi];
		int ploc= lo;
		for (int i= lo;i<hi;i++) {
        	if(a[i]<=p) {
        		swap(a,ploc++,i);
        	}
        	
        }
		swap(a,ploc,hi);
		return ploc;
		
	}
	
	public static void swap(int[] a, int i,int j) {
		int tem = a[i];
		a[i]=a[j];
		a[j]=tem;
	}
	
        
	
	public static int findKthLargest(int[] nums, int k) {
		int low=0;
		int high = nums.length -1;
		k = nums.length - k;
		while(low<high) {
			int PartitionIndex= partition(nums, low, high);
			if(PartitionIndex<k) // checking right subarray 
				low= PartitionIndex+1;
			else if(PartitionIndex>k) // checking left subarray
				high = PartitionIndex -1;
			else
				break;
		}
		return nums[k];
	}


	public static void main(String[] args)  
	{ 
	    int[] array = {3,2,3,1,2,4,5,5,6}; 
	   
	    int len= array.length;          
	    int k = 4; 
	       
	    if(k> len) 
	    { 
	       System.out.println("Index out of bound"); 
	    } 
	    else
	    { 
	        // find kth largest value 
	        System.out.println("K-th largest element in array : " + findKthLargest(array,k));
		    }  
		} 
	}



