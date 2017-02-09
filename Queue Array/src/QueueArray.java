
public class QueueArray<T> {
	private Object[] queue;
	private int head, tail;
	private int size;
	
	public QueueArray(int size)
	{
		this.size = size;
		queue = new Object[size];
		head = tail = 0;
	}
	
	public void enqueue(T value)
	{
		if(this.full())
		{
			//queue overflow
			return;
		}
		queue[tail] = value;
		tail = (tail == size - 1) ? 0 : tail + 1;
	}
	
	public T dequeue()
	{
		if(this.empty())
		{
			//queue underflow
			return null;
		}
		T value = (T)queue[head];
		head = (head == size - 1) ? 0 : head + 1;
		return value;
	}
	
	public boolean empty()
	{
		return (head == tail);
	}
	
	public boolean full()
	{
		//queue is empty
		if(this.empty())
		{
			return false;
		}
		//head is in first position
		if(head == 0)
		{
			if(tail == size - 1)
			{
				return true;
			}
			return false;
		}
		//any other position
		if(head - tail == 1)
		{
			return true;
		}
		return false;
	}
	
	
}
