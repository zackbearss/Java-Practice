
public class QueueLinkedList<T> {
	private SList<T> queue;
	
	public QueueLinkedList()
	{
		queue = new SList<>();
	}
	
	public void enqueue(T value)
	{
		queue.push_back(value);
	}
	
	public T dequeue()
	{
		if(queue.size == 0)
		{
			//underflow
			return null;
		}
		return queue.pop_front();
	}
	
	public boolean empty()
	{
		return (queue.size == 0) ? true : false;
	}

}
