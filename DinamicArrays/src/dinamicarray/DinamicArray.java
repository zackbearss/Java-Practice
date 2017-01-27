package dinamicarray;

public class DinamicArray<T> {
	private int capacity;
	private int size;
	private Object[] array;
	
	public DinamicArray(){
		capacity = 16;
		size = 0;
		
		array = new Object[16];
	}
	
	public int getSize(){
		return size;
	}
	
	public int getCapacity(){
		return capacity;
	}
	
	public boolean is_empty(){
		return (size == 0) ? true : false;
	}
	
	@SuppressWarnings("unchecked")
	public T at(int index){
		if(index >= size){
			throw new ArrayIndexOutOfBoundsException();
		}
		return (T)array[index];
	}
	
	public void push(T item){
		//resize array if too small
		if(size >= capacity){
			resize(capacity * 2);
		}
		array[size] = item;
		size++;
	}
	
	public void insert(int index, T item){
		//index not available
		if(index > size){
			return;
		}
		//resize array if too small
		if(size >= capacity){
			resize(capacity * 2);
		}
		//check if at end
		if(index == size){
			array[size] = item;
			size++;
			return;
		}
		Object[] tempArray = new Object[size-index];
		//copy array
		for(int i = 0; i < size - index; i++){
			tempArray[i] = array[i + index];
		}
		array[index] = item;
		//copy back array
		for(int i = 0; i < size - index; i++){
			array[index + 1 + i] = tempArray[i];
		}
		size++;
	}
	
	public void prepend(T item){
		insert(0, item);
	}
	
	public T pop(){
		size--;
		if(size <= capacity/4){
			resize((int)capacity/4);
		}
		return (T)array[size];
	}
	
	public void delete(int index){
		if(index >= size){
			return;
		}
		//if at end
		if(index == size - 1){
			size--;
			return;
		}
		//remove from middle
		Object[] tempArray = new Object[size-index];
		//copy array
		for(int i = 0; i < size - index; i++){
			tempArray[i] = array[i + index];
		}
		//copy back array
		for(int i = 0; i < size - index; i++){
			array[index + i] = tempArray[i];
		}
		size--;
	}
	
	public void remove(T item){
		int i = 0;
		while(i < size){
			if(array[i] == item){
				delete(i);
				continue;
			}
			i++;
		}
	}
	
	public int find(T item){
		for(int i = 0; i < size; i++){
			if(array[i] == item){
				return i;
			}
		}
		return -1;
	}
	
	private void resize(int new_capacity){
		Object[] tempArray = new Object[size];
		//copy array
		for(int i = 0; i < size; i++){
			tempArray[i] = array[i];
		}
		capacity = new_capacity;
		array = new Object[capacity];
		//copy back array
		for(int i = 0; i < size; i++){
			array[i] = tempArray[i];
		}	
	}
}
