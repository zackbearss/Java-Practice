
public class SNode<T> {
	T value;
	SNode<T> next;
	
	SNode(T value, SNode<T> next)
	{
		this.value = value;
		this.next = next;
	}
}
