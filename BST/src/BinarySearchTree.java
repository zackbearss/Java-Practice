
public class BinarySearchTree {
	//node class
	class Node{
		Node left;
		Node right;
		Integer value;
		
		public Node(){
			left = null;
			right = null;
			this.value = null;
		}
		
		public Node(int value){
			left = null;
			right = null;
			this.value = value;
		}
	}
	
	Node root;
	
	public BinarySearchTree(){
		root = new Node();
	}
	
	public BinarySearchTree(int rootValue){
		root = new Node(rootValue);
	}
	
	/*
	 * Public insertion of a value into the BST
	 * 
	 * @param value Value that is wanted to be inserted to the BST
	 */
	public void insert(int value){
		Node tempNode = new Node(value);
		
		//if root is empty, this node becomes the root
		if(root.value == null)
		{
			root = tempNode;
			return;
		}	
		
		insert(root, tempNode);
	}
	
	/*
	 * Really clever recursion method to print a tree
	 * 
	 * @startingNode Whatever tree starting point you want to print (can be a subtree within tree)
	 */
	public void PrintValues(){
		PrintValues(root);
	}
	
	/*
	 * Really clever recursion method to print a tree
	 * 
	 * @startingNode Whatever tree starting point you want to print (can be a subtree within tree)
	 */
	private void PrintValues(Node startingNode){
		if(startingNode == null)
			return;
		
		PrintValues(startingNode.left);
		System.out.println(startingNode.value);
		PrintValues(startingNode.right);
	}
	
	/*
	 * Since java has a garbage collector, just have to delete the reference to all nodes
	 */
	public void DeleteTree(){
		root = null;
	}
	
	/*
	 * Check to see if value is in BST
	 * 
	 * @vparam value The value to look for
	 */
	public boolean IsInTree(int value){
		return IsInTree(root, value);
	}
	
	/*
	 * Find the height of the BST
	 * 
	 * @return The heigh of the BST
	 */
	public int FindHeight(){
		return FindHeight(root);
	}
	
	/*
	 * Return the minimum number in BST
	 * 
	 * @return The minimum number in BST
	 */
	public int GetMin(){
		return GetMin(root);
	}
	
	/*
	 * Return the minimum number in BST
	 * 
	 * @param node The node to compare
	 * @return The minimum number in BST
	 */
	private int GetMin(Node node){
		if(node.left == null)
			return node.value;
		
		return GetMin(node.left);
	}
	
	/*
	 * Return the max number in BST
	 */
	public int GetMax(){
		return GetMax(root);
	}
	
	/*
	 * Return the max number in BST
	 * 
	 * @param node The node to compare
	 * @return The maximum number in BST
	 */
	private int GetMax(Node node){
		if(node.right == null)
			return node.value;
		
		return GetMax(node.right);
	}
	
	/*
	 * Find max heigh of tree
	 * 
	 * @param node The node to find height of
	 * @return The max height of the tree
	 */
	private int FindHeight(Node node){
		if(node == null)
			return 0;
		return 1 + MaxNum(FindHeight(node.left), FindHeight(node.right));
	}
	
	/*
	 * Helper function to find the max value between two numbers
	 * 
	 * @param value The first value to compare
	 * @param value2 The second value to compare
	 * @return The maximum value between the two
	 */
	private int MaxNum(int value, int value2){
		if(value >= value2){
			return value;
		}
		else{
			return value2;
		}
	}
	
	/*
	 * The private recursive function that looks for the value
	 * 
	 * @param node The node that the recursive function is at
	 * @vparam value The value to look for
	 */
	private boolean IsInTree(Node node, int value){
		if(node == null)
			return false;
		
		if(node.value > value)
			return IsInTree(node.left, value);
		else if(node.value < value)
			return IsInTree(node.right, value);
		else
			return true;
	}
	
	/*
	 * Behind the scenes insert using recursion. 
	 * 
	 * @param parent The node that is being compared to and will eventually be a parent (or grandparent etc.)
	 * @param newNode The new node that will be inserted to the BST
	 */
	private void insert(Node parent, Node newNode){
		//one rule in designing BST, equal values will be placed in the left subtree
		if(newNode.value <= parent.value){
			if(parent.left != null)
				insert(parent.left, newNode);
			else
				parent.left = newNode;
		}
		else if(newNode.value > parent.value){
			if(parent.right != null)
				insert(parent.right, newNode);
			else
				parent.right = newNode;
		}
	}
}
