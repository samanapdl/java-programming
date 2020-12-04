


package array;

public class Stack <E extends Object>{
	private int stackSize;
	private E[] stackArray;
	private int top;
	
	//Constructor Create stack with size
	public Stack(int size) {
		this.stackSize=size;
		this.stackArray=(E[]) new Object[stackSize];
		this.top= -1;
	}
	
	//check if the stack is empty; return true if empty
	public boolean isEmpty() {
        return (top == -1);}
	
	//add new value to the top of the stack
	public void push(E value) {
		System.out.println("Value added: "+value);
		this.stackArray[++top]=value;
	}
	
	//removes value from the top of the stack
	public E pop() throws Exception {
    if(this.isEmpty()){
        throw new Exception("Stack is empty. Can not remove element.");}
    E value = this.stackArray[top--];
    System.out.println("Removed entry: "+value);
    return value;
	}
	
	//returns top of stack without removing it
	public E peek() {
        return stackArray[top];
    }
	
	public static void main(String arg[]) throws Exception {
        Stack<Integer> stackA = new Stack<Integer>(5);
        stackA.push(20);
        stackA.push(15);
        stackA.push(23);
        stackA.push(5);
        stackA.push(2);
        
        stackA.pop();
        //stackA.pop();
             
        System.out.println("Value at top:"+ stackA.peek());
              
        
	}}
	
	
	
       