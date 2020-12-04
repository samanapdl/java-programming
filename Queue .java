
public class Queue<E extends Object>{
	  private E[] array;
	  private int size;
	  private int first;
	  private int last;
	  
	  public Queue(int max_size) {
		  array= (E[]) new Object[max_size];
		  first = 0;
		  last =  -1;
		  size = 0;
		  
		 	  
		  	  }
	//return the total number of stored elements
	  public int Size() {
		  return size;
	  }
	 
	//return if the queue is empty
	  public boolean isEmpty() {
		  return (size == 0 );
		  
	  }
	 
	//return if the queue is full  
	  public boolean isFull() {
		  return (size == array.length) ;
		  
	  }
	 
	//enqueue an element val for generic type E
	  public void offer(E val)
	  {
		  if (isFull()){
			  System.out.println("The queue is full");
			  return; 
		  }
		  
		  last = (last+1)% array.length;
		  array[last]= val;
		  
		  size++;
	      System.out.println(val 
                    + " adding to queue"); 
	  }
		  
	        
	//remove head and return the removed value, return null if isEmpty()	  
	  public E poll()
	  {
		 if (isEmpty()) {
			 System.out.println("The queue is empty ");
			 return null;
		 }
		 E val = array[first];
		 first = (first + 1) % array.length;
		 size--;
		 return val;
		 	 
	  }
	  
	//return head, return null if isEmpty()
	  public E peek() {
		  if (isEmpty()) {
			  System.out.println("The queue is empty ");
			  System.exit(1);
		  }
		  return(array[first]);
		  }
	  
	  
	//Driver method
	public static void main (String[] args)
	{
		// create a queue of capacity 5
		Queue<Integer> Q = new Queue<Integer>(5);

		Q.offer(5);
		Q.offer(4);
		Q.offer(3);
		Q.offer(2);
		Q.offer(1);
		//Q.offer(6);
		
		
		System.out.println("Queue size is " + Q.Size());
		
		System.out.println("Returning head element value: " + Q.peek());
		System.out.println("Removing head element " + Q.poll());
		
		System.out.println("Returning head element value: " + Q.peek());
		System.out.println("Removing head element " + Q.poll());

		System.out.println("Queue size is " + Q.Size());



	}
}


