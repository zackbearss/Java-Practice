public class DList<T> {
	DNode<T> head;
	DNode<T> tail;
	int size;
	
	/**
	 * Constructor for SList
	 */
	DList()
	{
		//init vars
		size = 0;
		head = new DNode<>(null, null, null);
		tail = head;
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
		//fast access to head
		if(index == 0)
		{
			return head.value;
		}
		//fast access to tail
		if(index == size - 1)
		{
			return tail.value;
		}
		//look through rest of list
		int counter = 1;
		DNode<T> temp = head.next;
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
		DNode<T> temp = new DNode<>(value, head, null);
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
		if(size != 1)
		{
			head = head.next;
		}
		head.prev = null;
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
		DNode<T> temp = new DNode<T>(value, null, tail);
		tail.next = temp;
		tail = temp;
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
		if(size == 1)
		{
			T value = head.value;
			head.value = null;
			size--;
			return value;
		}
		
		T value = tail.value;
		tail = tail.prev;
		tail.next = null;
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
		return tail.value;
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
		//fast access to head
		if(index == 0)
		{
			this.push_front(value);
		}
		//fast access to tail
		if(index == size)
		{
			this.push_back(value);
		}
		
		DNode<T> temp = new DNode<>(value, null, null);
		DNode<T> traverseCurrent = head;
		DNode<T> traversePast = head;
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
		
		traversePast.next = temp;
		traverseCurrent.prev = temp;
		temp.next = traverseCurrent;
		temp.prev = traversePast;
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
		//fast head access
		if(index == 0)
		{
			this.pop_front();
			return;
		}
		//fast tail access
		if(index == size - 1)
		{
			this.pop_back();
			return;
		}
		
		DNode<T> traverseCurrent = head;
		DNode<T> traversePast = head;
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
		traverseCurrent.prev = traversePast;
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
		
		DNode<T> traverse = tail;
		int counter = 0;
		//traverse list
		while(counter < n)
		{
			traverse = traverse.prev;
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
//		if(size < 2)
//		{
//			return;
//		}
//		
//		DNode<T> reverseHead  = tail;
//		DNode<T> reverseTraverse = reverseHead;
//		DNode<T> reversalTempStorage = new DNode<>(null, null);
//		
//		for(int i = size - 2; i >= 0; i--)
//		{
//			reversalTempStorage.value = this.value_at(i);
//			reversalTempStorage.next = null;
//			
//			reverseTraverse.next = reversalTempStorage;
//			reverseTraverse = reverseTraverse.next;
//			reversalTempStorage = new DNode<>(null, null);
//		}
//		tail = head;
//		head = reverseHead;
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
		
		DNode<T> traverse = head;
		for(int i = 0; i < size; i++)
		{
			if(traverse.value == value)
			{
				this.erase(i);
				return;
			}
			traverse = traverse.next;
		}
	}
}
