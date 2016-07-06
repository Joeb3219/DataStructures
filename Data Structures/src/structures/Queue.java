package structures;

import java.util.NoSuchElementException;

public class Queue<T> {

	private DynamicArray<T> arrList;
	private int size = 0;
	
	public Queue(){
		arrList = new DynamicArray<T>();
	}
	
	public void enqueue(T obj){
		size ++;
		arrList.add(obj);
	}
	
	public T dequeue(){
		if(size == 0) throw new NoSuchElementException();
		size --;
		return arrList.remove(0);
	}
	
}
