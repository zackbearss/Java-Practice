
public class DNode<T> {
	T value;
	DNode<T> next;
	DNode<T> prev;
	
	DNode(T value, DNode<T> next, DNode<T> prev)
	{
		this.value = value;
		this.next = next;
		this.prev = prev;
	}
}
