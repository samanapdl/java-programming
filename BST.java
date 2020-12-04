import java.util.Stack;

class BST<E extends Comparable<E>> {
	
	public Node root;

	class Node {
		E val;
		Node leftNode;
		Node rightNode;

		Node(E val) {
			this.val = val;
		}
	}
	
	public boolean isEmpty() {
		return (root == null);
	}
	
	
	/*************************"****************************
	*
	*            Tree Size
	*
	******************************************************/
	
    
	public int size() {
	     return(size(root));
	  }

    private int size(Node node) {
    	if (node == null) return(0);
    	else {
    		return(size(node.leftNode) + 1 + size(node.rightNode));}
	  } 
	
	/*************************"****************************
	*
	*            MAXIMUM VALUE
	*
	******************************************************/
	
	// returns the maximum value stored in the tree currently
	public E max() {
		if (isEmpty())
			return null;
		else {
			Node node = root;
			while (node.rightNode != null)
				node = node.rightNode;
			return node.val;
		}
	}

	

	/*****************************************************
	*
	*            COINTAINS
	*
	******************************************************/
	public boolean contains(E target) {
		if (contains(root, target)) {
			return true;
		}
		return false;
	}
	
	private boolean contains(Node node, E target) {

		if (node == null)
			return false; // target is not found
		else if (node.val == target) {
			return true;
		} else if (target.compareTo(node.val) < 0) {
			return contains(node.leftNode, target);
		} else if (target.compareTo(node.val) > 0) {
			return contains(node.rightNode, target);
		} else
			return true;
	}



	


	/*****************************************************
	*
	*            Insert
	*
	******************************************************/

	public boolean insert(E val) {
		if (!contains(val)) {
			root = insert(root, val);
			return true;
		}

		return false;
	}

	private Node insert(Node node, E value) {
		if (node == null)
			node = new Node(value);

		else if (value.compareTo(node.val) < 0)
			node.leftNode = insert(node.leftNode, value); // Add in leftNode subtree

		else if (value.compareTo(node.val) >= 0)
			node.rightNode = insert(node.rightNode, value); // Add in rightNode subtree

		return node;
	}

	

	/*****************************************************
	*
	*            DELETE
	*
	******************************************************/
	//Delete the node with the input value if it's found in the tree
	public void delete(E val) {
		root = delete(root, val);
	} 

	private Node delete(Node node, E value){
		if(node ==null) throw new RuntimeException("cannot delete.");
		
		else if (value.compareTo(node.val) < 0)
		      node.leftNode = delete (node.leftNode, value);
		
		else if (value.compareTo(node.val) > 0)
		      node.rightNode = delete (node.rightNode, value);
		else{
			if(node.leftNode== null) return node.rightNode;
			if(node.rightNode== null) return node.leftNode;
			else {
				
				node.val= retrieveData(node.leftNode);
				node.leftNode = delete (node.leftNode, node.val);
			}}
		return node;
		}
			
			   
		     
	private E retrieveData(Node node)
	   {
	      while (node.rightNode != null) node = node.rightNode;

	      return node.val;
	   }

	/*****************************************************
	*
	*            TRANSVERSAL
	*
	******************************************************/
	//post-order traversal method : recursive manner
	public void postOrder() {
		postOrder(root); 
	} 
	
	private void postOrder(Node node) { 
		if (node == null) 
			return; 
		postOrder(node.leftNode); 
		postOrder(node.rightNode); 
		System.out.printf("%s ", node.val); 
	}

	//pre-order traversal method: recursive 
	public void preOrder() {
		preOrder(root); 
	} 
	
	private void preOrder(Node node) { 
		if (node == null) 
			return; 
		System.out.printf("%s ", node.val);
		preOrder(node.leftNode); 
		preOrder(node.rightNode); 
		 
	}
	
	//inorder traversal method : recursive
	public void inOrderRecur() {
		inOrderRecur(root); 
	} 
	
	private void inOrderRecur(Node node) { 
		if (node == null) 
			return; 
		
		inOrderRecur(node.leftNode); 
		System.out.printf("%s ", node.val);
		inOrderRecur(node.rightNode); 
		 
	}
	
	//inorder traversal method : iterative
	public void inOrderIterative() {
		Stack<Node> nodeStack = new Stack<>();
		Node current_node = root;
		while (!nodeStack.isEmpty()|| current_node!=null) {
			if (current_node !=null) {
				nodeStack.push(current_node);
				current_node = current_node.leftNode;}
			else {
				Node node =nodeStack.pop();
				System.out.printf("%s ", node.val);
                current_node = node.rightNode;}
			}
		}
	
	/*****************************************************
	*
	*            MAIN METHOD
	*
	******************************************************/

	public static void main(String[] args) {

		BST<Integer> bst = new BST<Integer>();

		Integer[] a = {10, 89, 51, 7, 40, 50 ,34 };
		for (Integer n : a)
			bst.insert(n);

		System.out.println("The maximum value is: " + bst.max());

//		if (bst.contains(10))
//			System.out.println("contains ");
//		else
//			System.out.println("doesn't contain ");
		
		System.out.println("\nPreorder traversal of binary tree is ");
		bst.preOrder();
		System.out.println("\n\nPostorder traversal of binary tree is "); 
		bst.postOrder();
		System.out.println("\n\nInorder traversal Iterative method of binary tree is "); 
	    bst.inOrderIterative();
		System.out.println("\n\nInorder traversal Recurrsive method of binary tree is "); 
		bst.inOrderRecur();
		System.out.println("\n\nThe size of the tree is " + bst.size());
//		bst.delete(10);
//		System.out.println("\The size of the tree is " + bst.size());

	}

}
