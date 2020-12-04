
import java.util.Arrays;
import java.util.NoSuchElementException;


class MaxHeap{
		private int max_size;
		private int size=0;
		private int [] heap;
	    
		public MaxHeap(int max_size) {
		    this.max_size = max_size;
		    this.heap = new int[max_size];
		   
		  }
		 private int LeftIndex(int i) {
		    return 2 * i + 1;}

	     private int RightIndex(int i) {
		    return 2 * i + 2;}
     			  
		 private int ParentIndex(int i) {
		    return (i - 1) / 2;
		  }

		 private void swap(int a, int b) {
		    int element = heap[a];
		    heap[a] = heap[b];
		    heap[b] = element;
		  }
			  
	     private void MaximumSize() {
		    if (size == max_size) {
		      heap = Arrays.copyOf(heap, max_size * 2);
		      max_size = max_size * 2;
		    }
		  }
	     
		 public void offer(int val) {
			 MaximumSize();
		     heap[size] = val;
		     size++;
		     heapify_up();
		   }
		  
		  public boolean isEmpty() {
			 return (size == 0 );
     	   }

		  public int peek() {
			 if (isEmpty()) {
			      throw new NoSuchElementException();
			    }
			 return heap[0];
		   }

		  public void poll() {
			 if (isEmpty()) {
			      throw new NoSuchElementException();
	             }

			 heap[0] = heap[size - 1];
			 size--;
			 heapify_down();
			}

		  private void heapify_down() {
			  int i = 0;
     		  while (LeftIndex(i) < size) {
			      int smallestChildIndex = LeftIndex(i);
			      if ((RightIndex(i) < size) && (heap[RightIndex(i)]) < (heap[LeftIndex(i)])) {
			        smallestChildIndex = RightIndex(i);
			      }
			      if (heap[i] < heap[smallestChildIndex]) {
			        swap(i, smallestChildIndex);
			      } 
			      else {
			        break;
			      }
			      i = smallestChildIndex;
			    }
			  }

		  private void heapify_up() {
			 int i = size - 1;
			 while ((ParentIndex(i) >= 0) && heap[ParentIndex(i)] < heap[i]) {
			      swap(ParentIndex(i), i);
			      i = ParentIndex(i);
			    }
			  }


		  public  int size()
			    {
			        return size();
			    }
		 
		  public static void main(String[] args) {
				    MaxHeap maxHeap = new MaxHeap(5);

				    maxHeap.offer(90);
				    maxHeap.offer(5);
				    maxHeap.offer(10);
				    maxHeap.offer(6);
				    maxHeap.offer(19);
			    
				    for (int i = 0; i < maxHeap.size; i++) {
					      System.out.print(maxHeap.heap[i] + " ");
					    }
				  	  }
				}
		