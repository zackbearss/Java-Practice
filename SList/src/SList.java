public class SList<T> {
	SNode<T> head;
	int size;
	
	/**
	 * Constructor for SList
	 */
	SList()
	{
		//init vars
		size = 0;
		head = new SNode<>();
		head.next = null;
	}
	
	/**
	 * Returns the size of the list
	 * @return size
	 */
	int size()
	{
		return size;
	}
	
	/**
	 * Checks if the list is empty
	 * @return True if empty / False if not empty
	 */
	boolean empty()
	{
		return (size == 0);
	}

	/**
	 * Returns the value at a certain index
	 * @param index The index in the list
	 * @return Value at the index
	 */
	T value_at(int index)
	{
		//check size
		if(index >= size)
		{
			return null;
		}
		
		int counter = 0;
		SNode<T> temp = head;
		//traverse list
		while(counter != index)
		{
			temp = temp.next;
			counter++;
		}
		return temp.value;
	}
	
	/**
	 * Push a new node at the front of the list
	 * @param value The value to go in the new node
	 */
	void push_front(T value)
	{
		//check size, if 0, update heaad
		if(size == 0)
		{
			head.value = value;
			size++;
			return;
		}
		//change head with new node
		SNode<T> temp = new SNode<>();
		temp.value = value;
		temp.next = head;
		head = temp;
		size++;
	}
	
	/**
	 * Removes the first node of the list and returns
	 * @return Value that was popped
	 */
	T pop_front()
	{
		//check size
		if(size == 0)
		{
			return null;
		}
		//pop head
		T value = head.value;
		head = head.next;
		size--;
		return value;
	}
	
	/**
	 * Create a new node at the end of the list
	 * @param value The value that goes into the new node
	 */
	void push_back(T value)
	{
		//check size
		if(size == 0)
		{
			head.value = value;
			size++;
			return;
		}
		SNode<T> temp = new SNode<>();
		SNode<T> traverse = head;
		//update new node's vars
		temp.value = value;
		temp.next = null;
		//traverse list
		while(traverse.next != null)
		{
			traverse = traverse.next;
		}
		traverse.next = temp;
		size++;
	}
	
	/**
	 * Remove the last node of the list and return the value
	 * @return The value that was popped
	 */
	T pop_back()
	{
		//check size
		if(size == 0)
		{
			return null;
		}
		SNode<T> traverseCurrent = head;
		SNode<T> traversePast = head;
		//traverse list
		while(traverseCurrent.next != null)
		{	
			if(traverseCurrent == traversePast)
			{
				traverseCurrent = traverseCurrent.next;
			}	
			else
			{
				traversePast = traverseCurrent;
				traverseCurrent = traverseCurrent.next;
				
			}
		}
		T value = traverseCurrent.value;
		traversePast.next = null;
		size--;
		return value;
	}
	
	/**
	 * Returns the value of the first node
	 * @return The value in the first node
	 */
	T front()
	{
		//check size
		if(size == 0)
		{
			return null;
		}
		return head.value;
	}
	
	/**
	 * Returns the value in the last node
	 * @return The value in the last node
	 */
	T back()
	{
		//check size
		if(size == 0)
		{
			return null;
		}
		
		SNode<T> traverse = head;
		//traverse list
		while(traverse.next != null)
		{
			traverse = traverse.next;
		}
		
		return traverse.value;
	}
	
	/**
	 * Inserts a new node at a certain index of the list
	 * @param index The index to place the node
	 * @param value The value that goes in the new node
	 */
	void insert(int index, T value)
	{
		//check size, if the size is 0 and index is 0, go ahead
		if(size == 0)
		{
			if(index == 0)
			{
				this.push_back(value);
			}
			return;
		}
		
		SNode<T> temp = new SNode<>();
		SNode<T> traverseCurrent = head;
		SNode<T> traversePast = head;
		int counter = 0;
		
		temp.value = value;
		//traverse list
		while(counter != index)
		{
			if(traverseCurrent == traversePast)
			{
				traverseCurrent = traverseCurrent.next;
			}
			else
			{
				traversePast = traverseCurrent;
				traverseCurrent = traverseCurrent.next;
			}
			counter++;
		}
		
		traversePast.next = temp;
		temp.next = traverseCurrent;
		size++;
	}
	
	/**
	 * Erases a node at a certain index
	 * @param index The index of the node to erase
	 */
	void erase(int index)
	{
		//check size
		if(size == 0)
		{
			return;
		}
		
		if(index == 0)
		{
			head = head.next;
			size--;
			return;
		}
		
		SNode<T> traverseCurrent = head;
		SNode<T> traversePast = head;
		int counter = 0;
		//traverse list
		while(counter != index)
		{
			if(traverseCurrent == traversePast)
			{
				traverseCurrent = traverseCurrent.next;
			}
			else
			{
				traversePast = traverseCurrent;
				traverseCurrent = traverseCurrent.next;
			}
			
			counter++;
		}
		
		traversePast.next = traverseCurrent.next;
		size--;
	}
	
	/**
	 * Returns the value of the node n from the end
	 * @param n How many nodes away from the end
	 * @return Value from the selected node
	 */
	T value_n_from_end(int n)
	{
		//check size, and make sure n from end makes sense
		if(size == 0 || (size - n) <= 0)
		{
			return null;
		}
		
		SNode<T> traverse = head;
		int counter = 0;
		//traverse list
		while(counter != size - n - 1)
		{
			traverse = traverse.next;
			counter++;
		}
		return traverse.value;
	}
	
	/**
	 * Reverse a linked list
	 */
	void reverse()
	{
		//check size, only makes sense that size is 2 or more
		if(size < 2)
		{
			return;
		}
		
		SNode<T> reverseHead = new SNode<>();
		SNode<T> reverseTraverse;
		SNode<T> reversalTempStorage = new SNode<>();
		
		reverseHead.value = this.pop_back();
		reverseHead.next = null;
		
		for(int i = 1; i < size; i++)
		{
			reversalTempStorage.value = this.pop_back();
			reversalTempStorage.next = null;
			
			reverseTraverse = reverseHead;
			//traverse list
			while(reverseTraverse.next != null);
			{
				reverseTraverse = reverseTraverse.next;
			}
			reverseTraverse.next = reversalTempStorage;
			reversalTempStorage = new SNode<>();
		}
		head = reverseHead;
	}
	
	/**
	 * Remove the first node to contain a certain value
	 * @param value The value to look for
	 */
	void remove_value(T value)
	{
		//check size
		if(size == 0)
		{
			return;
		}
		
		SNode<T> traverse = head;
		for(int i = 0; i < size; i++)
		{
			if(traverse.value == value)
			{
				this.erase(i);
			}
			traverse = traverse.next;
		}
	}
}
