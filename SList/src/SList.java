public class SList<T> {
	SNode<T> head;
	int size;
	
	SList()
	{
		size = 0;
		head = new SNode<>();
		head.next = null;
	}
	
	int size()
	{
		return size;
	}
	
	boolean empty()
	{
		return (size == 0);
	}

	T value_at(int index)
	{
		if(index >= size)
		{
			//throw new ArrayIndexOutOfBoundsException();
			return null;
		}
		
		int counter = 0;
		SNode<T> temp = head;
		while(counter != index)
		{
			temp = temp.next;
		}
		return temp.value;
	}
	
	void push_front(T value)
	{
		if(size == 0)
		{
			head.value = value;
			size++;
			return;
		}
		SNode<T> temp = new SNode<>();
		temp.value = value;
		temp.next = head;
		head = temp;
		size++;
	}
	
	T pop_front()
	{
		if(size == 0)
		{
			return null;
		}
		T value = head.value;
		head = head.next;
		size--;
		return value;
	}
	
	void push_back(T value)
	{
		if(size == 0)
		{
			head.value = value;
			size++;
			return;
		}
		SNode<T> temp = new SNode<>();
		SNode<T> traverse = head;
		temp.value = value;
		temp.next = null;
		
		while(traverse.next != null)
		{
			traverse = traverse.next;
		}
		traverse.next = temp;
	}
	
	T pop_back()
	{
		if(size == 0)
		{
			return null;
		}
		SNode<T> traverse = head;
		while(traverse.next.next != null)
		{
			traverse = traverse.next;
		}
		T value = traverse.next.value;
		traverse.next = null;
		size--;
		return value;
	}
	
	T front()
	{
		if(size == 0)
		{
			return null;
		}
		return head.value;
	}
	
	T back()
	{
		if(size == 0)
		{
			return null;
		}
		
		SNode<T> traverse = head;
		while(traverse.next != null)
		{
			traverse = traverse.next;
		}
		
		return traverse.value;
	}
	
	void insert(int index, T value)
	{
		if(size == 0 && index != 0)
		{
			return;
		}
		
		SNode<T> temp = new SNode<>();
		SNode<T> traverse = head;
		int counter = 0;
		
		temp.value = value;
		while(counter != index - 1)
		{
			traverse = traverse.next;
			counter++;
		}
		
		temp.next = traverse.next.next;
		traverse.next = temp;
		size++;
	}
	
	void erase(int index)
	{
		if(size == 0)
		{
			return;
		}
		
		SNode<T> traverse = head;
		int counter = 0;
		
		while(counter != index - 1)
		{
			traverse = traverse.next;
			counter++;
		}
		
		traverse.next = traverse.next.next;
		size--;
	}
	
	T value_n_from_end(int n)
	{
		if(size == 0 || (size - n) < 0)
		{
			return null;
		}
		
		SNode<T> traverse = head;
		int counter = 0;
		while(counter != size - n)
		{
			traverse = traverse.next;
			counter++;
		}
		return traverse.value;
	}
	
	void reverse()
	{
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
			while(reverseTraverse.next != null);
			{
				reverseTraverse = reverseTraverse.next;
			}
			reverseTraverse.next = reversalTempStorage;
			reversalTempStorage = new SNode<>();
		}
		head = reverseHead;
	}
	
	void remove_value(T value)
	{
		if(size == 0)
		{
			return;
		}
		
		SNode<T> traverse = head;
		while(traverse.next != null)
		{
			if(traverse.next)
		}
	}
}
